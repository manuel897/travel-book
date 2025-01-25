package com.example.controller;

import com.example.models.booking.BookingInputDto;
import com.example.domain.booking.BookingRepository;
import com.example.domain.booking.BookingService;
import org.springframework.stereotype.Component;

@Component
public class BookingControllerImpl implements BookingController {
    private final BookingService bookingService;
    private final BookingRepository bookingRepository;

    public BookingControllerImpl(BookingService bookingService, BookingRepository bookingRepository) {
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
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
