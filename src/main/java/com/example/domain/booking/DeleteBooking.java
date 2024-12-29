package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import com.example.domain.user.UserRole;

import java.util.Objects;

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

    public void call(BookingModel bookingModel) {
        final UserDataModel actionUser = userRepository.findByUserId(bookingModel.userId);
        if(actionUser == null) {
            throw new UserNotFoundException("User id " + bookingModel.userId + " not found");
        }

        final BookingDataModel existingBooking = bookingRepository.findByBookingId(bookingModel.bookingId);
        if(existingBooking == null) {
            throw new BookingNotFoundException(bookingModel.bookingId);
        }

        // only owner or manager can delete booking
        final boolean isActionAllowed = Objects.equals(existingBooking.getOwnerId(), bookingModel.userId)
                || UserRole.MANAGER.name().equals(actionUser.getUserRole());
        if(!isActionAllowed) {
            bookingPresenter.presentActionNotAllowed();
            return;
        }

        bookingRepository.deleteBooking((existingBooking.getBookingId()));
        bookingPresenter.presentBookingDeleted(bookingModel.bookingId);
    }
}