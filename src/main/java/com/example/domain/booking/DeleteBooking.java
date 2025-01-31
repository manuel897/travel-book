package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.models.booking.BookingInputDto;
import com.example.domain.booking.models.BookingNotFoundException;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import com.example.models.user.UserConverter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class DeleteBooking {
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final BookingPresenter bookingPresenter;

    DeleteBooking(
            BookingRepository bookingRepository,
            UserRepository userRepository,
            BookingPresenter bookingPresenter
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.bookingPresenter = bookingPresenter;
    }

    public void call(BookingInputDto bookingModel) {
        final Optional<UserDataModel> actionUser = userRepository.findByUsername(bookingModel.userId);
        if(actionUser.isEmpty()) {
            throw new UserNotFoundException("User id " + bookingModel.userId + " not found");
        }

        final BookingDataModel existingBooking = bookingRepository.findByBookingId(bookingModel.bookingId);
        if(existingBooking == null) {
            throw new BookingNotFoundException(bookingModel.bookingId);
        }

        // only owner or manager can delete booking
        UserConverter userConverter = new UserConverter();
        final User user = userConverter.toEntity(actionUser.get());

        final boolean isActionAllowed = Objects.equals(existingBooking.getOwnerId(), bookingModel.userId)
                || user.isManager();
        if(!isActionAllowed) {
            bookingPresenter.presentActionNotAllowed();
            return;
        }

        bookingRepository.deleteBooking((existingBooking.getBookingId()));
        bookingPresenter.presentBookingDeleted(bookingModel.bookingId);
    }
}