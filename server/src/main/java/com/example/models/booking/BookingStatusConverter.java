package com.example.models.booking;


import com.example.domain.booking.models.BookingStatus;
import com.example.models.EntityConverter;

public class BookingStatusConverter implements EntityConverter<BookingStatus, Integer> {

    @Override
    public BookingStatus toEntity(Integer d) {
        return switch (d) {
            case 0 -> BookingStatus.ENQUIRY;
            case 1 -> BookingStatus.CONFIRMED;
            case 2 -> BookingStatus.REJECTED;
            default -> throw new IllegalStateException("Unexpected value: " + d);
        };
    }
}
