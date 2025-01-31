package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.domain.booking.models.BookingStatus;
import com.example.models.booking.BookingInputDto;
import com.example.domain.booking.models.BookingNotFoundException;
import com.example.domain.booking.models.DistanceUnit;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import com.example.models.booking.BookingStatusConverter;
import com.example.models.user.UserConverter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

@Component
public class UpdateBooking {
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final BookingPresenter bookingPresenter;

    UpdateBooking(
            BookingRepository bookingRepository,
            UserRepository userRepository,
            BookingPresenter bookingPresenter
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.bookingPresenter = bookingPresenter;
    }

    public void call(BookingInputDto bookingInput) {
        final Optional<UserDataModel> userData = userRepository.findByUsername(bookingInput.userId);
        if(userData.isEmpty()) {
            throw new UserNotFoundException("User id " + bookingInput.userId + " not found");
        }

        final UserConverter userConverter = new UserConverter();
        final User user = userConverter.toEntity(userData.get());

        final BookingDataModel existingBooking = bookingRepository.findByBookingId(bookingInput.bookingId);
        if(existingBooking == null) {
            throw new BookingNotFoundException(bookingInput.bookingId);
        }

        // only owner or manager can update booking
        final boolean isActionAllowed = Objects.equals(existingBooking.getOwnerId(), bookingInput.userId)
                || user.isManager();
        if(!isActionAllowed) {
            bookingPresenter.presentActionNotAllowed();
            return;
        }

        final BookingStatusConverter statusConverter = new BookingStatusConverter();
        final BookingStatus status = statusConverter.toEntity(bookingInput.statusCode);

        final BookingDataModel updatedBookingDataModel = new BookingDataModel(
                bookingInput.bookingId,
                bookingInput.numberPlate,
                bookingInput.name,
                bookingInput.notes,
                bookingInput.departure,
                bookingInput.arrival,
                DistanceUnit.KM.name(), // TODO read from config file
                bookingInput.distance,
                bookingInput.start,
                bookingInput.end,
                status.getCode(),
                bookingInput.firstDriverId,
                bookingInput.secondDriverId,
                bookingInput.userId,
                Instant.now(),
                bookingInput.initialQuote
        );

        bookingRepository.updateBooking((updatedBookingDataModel));
        bookingPresenter.presentBookingUpdated(bookingInput.bookingId);
    }
}