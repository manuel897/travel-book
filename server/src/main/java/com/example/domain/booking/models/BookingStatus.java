package com.example.domain.booking.models;

public enum BookingStatus {
    ENQUIRY(0),
    CONFIRMED(1),
    REJECTED(2);

    private final int code;

    BookingStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
