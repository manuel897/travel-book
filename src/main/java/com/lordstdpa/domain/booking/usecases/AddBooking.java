package com.lordstdpa.domain.booking.usecases;

import com.lordstdpa.data.user.UserDataModel;
import com.lordstdpa.domain.booking.BookingModel;
import com.lordstdpa.domain.user.UserNotFoundException;
import com.lordstdpa.domain.user.UserRepository;

public class AddBooking {
    private UserRepository userRepository;

    public void call(BookingModel bookingModel) {
        final UserDataModel existingUser = userRepository.findByUserId(bookingModel.getUserId());

        if(existingUser == null) {
            throw new UserNotFoundException("User id " + bookingModel.getUserId() + "not found");
        }
    }
}
