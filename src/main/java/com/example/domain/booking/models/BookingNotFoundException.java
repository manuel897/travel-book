package com.example.domain.booking.models;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String bookingId) {
        super("Booking with id " + bookingId + " not found");
    }
}
