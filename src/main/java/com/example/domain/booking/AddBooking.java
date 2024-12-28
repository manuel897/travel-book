package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import com.example.domain.user.UserRole;

public class AddBooking {
    private UserRepository userRepository;
    private BookingRepository bookingRepository;
    private BookingDataModel existingBooking;

    public void call(BookingModel bookingModel) {
        final UserDataModel existingUser = userRepository.findByUserId(bookingModel.userId);
        if(existingUser == null) {
            throw new UserNotFoundException("User id " + bookingModel.userId + "not found");
        }

        final BookingDataModel newBookingDataModel = new BookingDataModel(
                null,
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

        bookingRepository.createBooking(newBookingDataModel);
    }
}