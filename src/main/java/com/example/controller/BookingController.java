package com.example.controller;

import com.example.models.booking.BookingInputDto;

public interface BookingController {
    void onGetAllBooking();

    void onGetBookingByUsername(String username);

    void onNewBooking(BookingInputDto booking);
}
