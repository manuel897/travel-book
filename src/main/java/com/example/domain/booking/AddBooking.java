package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;

public class AddBooking {
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    AddBooking(
            BookingRepository bookingRepository,
            UserRepository userRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    public void call(BookingModel bookingModel) {
        final UserDataModel existingUser = userRepository.findByUserId(bookingModel.userId);
        if(existingUser == null) {
            throw new UserNotFoundException("User id " + bookingModel.userId + " not found");
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