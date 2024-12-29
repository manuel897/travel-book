package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import com.example.domain.user.UserRole;

import java.util.Objects;

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

    public void call(BookingModel bookingModel) {
        final UserDataModel actionUser = userRepository.findByUserId(bookingModel.userId);
        if(actionUser == null) {
            throw new UserNotFoundException("User id " + bookingModel.userId + " not found");
        }

        final BookingDataModel existingBooking = bookingRepository.findByBookingId(bookingModel.bookingId);
        if(existingBooking == null) {
            throw new BookingNotFoundException(bookingModel.bookingId);
        }

        // only owner or manager can update booking
        final boolean isActionAllowed = Objects.equals(existingBooking.getOwnerId(), bookingModel.userId)
                || UserRole.MANAGER.name().equals(actionUser.getUserRole());
        if(!isActionAllowed) {
            bookingPresenter.presentActionNotAllowed();
            return;
        }

        final BookingDataModel updatedBookingDataModel = new BookingDataModel(
                bookingModel.bookingId,
                bookingModel.numberPlate,
                bookingModel.name,
                bookingModel.notes,
                bookingModel.departure,
                bookingModel.arrival,
                DistanceUnit.KM.name(), // TODO read from config file
                bookingModel.distance,
                bookingModel.start,
                bookingModel.end,
                bookingModel.bookingStatus.name(),
                bookingModel.firstDriverId,
                bookingModel.secondDriverId,
                bookingModel.userId,
                bookingModel.lastModifiedAt,
                bookingModel.initialQuote
                );

        bookingRepository.updateBooking((updatedBookingDataModel));
        bookingPresenter.presentBookingUpdated(bookingModel.bookingId);
    }
}