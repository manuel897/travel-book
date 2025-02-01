package com.example.controller;

import com.example.models.booking.BookingInputDto;
import com.example.domain.booking.BookingService;
import org.springframework.stereotype.Component;

@Component
public class BookingControllerImpl implements BookingController {
    private final BookingService bookingService;

    public BookingControllerImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void onGetAllBooking(String userId) {
        bookingService.getAllBookings(userId);
    }

    @Override
    public void onNewBooking(BookingInputDto booking) {
        bookingService.createBooking(booking);
    }
}
