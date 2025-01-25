package com.example.controller;

import com.example.domain.booking.BookingInputDto;
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

    public void createBooking(BookingInputDto bookingInput) {
        bookingService.createBooking(bookingInput);
    }

}
