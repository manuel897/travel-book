package com.example.domain.booking;

public class BookingConflictException extends RuntimeException {
    public BookingConflictException() {
        super("Booking conflicts with an existing booking");
    }
}
