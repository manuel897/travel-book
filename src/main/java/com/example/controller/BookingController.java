package com.example.controller;

import com.example.models.booking.BookingInputDto;

public interface BookingController {
    void onGetAllBooking(String userId);

    void onNewBooking(BookingInputDto booking);
}
