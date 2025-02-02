package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.domain.booking.models.BookingStatus;
import com.example.domain.user.User;
import com.example.models.booking.BookingInputDto;
import com.example.domain.booking.models.DistanceUnit;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import com.example.models.booking.BookingStatusConverter;
import com.example.models.user.UserConverter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class AddBooking {
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final BookingPresenter bookingPresenter;

    AddBooking(
            BookingRepository bookingRepository,
            UserRepository userRepository,
            BookingPresenter bookingPresenter
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.bookingPresenter = bookingPresenter;
    }

    public void call(BookingInputDto bookingInput) {
        final Optional<UserDataModel> foundUser = userRepository.findByUsername(bookingInput.userId);
        if(foundUser.isEmpty()) {
            throw new UserNotFoundException("User id " + bookingInput.userId + " not found");
        }

        final UserConverter userConverter = new UserConverter();
        final User user = userConverter.toEntity(foundUser.get());

        if(!user.isAllowedToCreateBooking()) {
            bookingPresenter.presentActionNotAllowed();
        }

        final BookingStatusConverter statusConverter = new BookingStatusConverter();
        final BookingStatus status = statusConverter.toEntity(bookingInput.statusCode);

        final BookingDataModel newBookingDataModel = new BookingDataModel(
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
                foundUser.get().getUsername(),
                Instant.now(),
                bookingInput.initialQuote
        );

        bookingRepository.createBooking(newBookingDataModel);
        bookingPresenter.presentBookingCreated(bookingInput.name);
    }
}