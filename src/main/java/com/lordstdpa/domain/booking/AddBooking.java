package com.lordstdpa.domain.booking;

import com.lordstdpa.data.booking.BookingDataModel;
import com.lordstdpa.data.user.UserDataModel;
import com.lordstdpa.domain.user.UserNotFoundException;
import com.lordstdpa.domain.user.UserRepository;
import com.lordstdpa.domain.user.UserRole;

import java.util.Objects;

public class AddBooking {
    private UserRepository userRepository;
    private BookingRepository bookingRepository;

    public void call(BookingModel bookingModel) {
        final UserDataModel existingUser = userRepository.findByUserId(bookingModel.getUserId());
        if(existingUser == null) {
            throw new UserNotFoundException("User id " + bookingModel.getUserId() + "not found");
        }

        final BookingDataModel existingBooking = bookingRepository.findBy(bookingModel.getNumberPlate(), bookingModel.getStart());
        if(existingBooking != null) {
            throw new BookingConflictException();
        }

        final String bookingStatusToSave = UserRole.DRIVER.name().equals(existingUser.getRole())
            ? BookingStatus.PENDING.name()
            : BookingStatus.CONFIRMED.name();

        final BookingDataModel newBookingDataModel = new BookingDataModel(
                null,
                bookingModel.name,
                bookingModel.notes,
                bookingModel.departure,
                bookingModel.arrival,
                DistanceUnit.KM.name(), // TODO read from config file
                bookingModel.distance,
                bookingModel.start,
                bookingModel.end,
                bookingStatusToSave,
                bookingModel.firstDriverId,
                bookingModel.secondDriverId,
                bookingModel.userId,
                bookingModel.lastModifiedAt
                );

        bookingRepository.createBooking(newBookingDataModel);
    }
}