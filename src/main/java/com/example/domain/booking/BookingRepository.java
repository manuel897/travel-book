package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;

import java.time.LocalDateTime;

public interface BookingRepository {
    String createBooking(BookingDataModel bookingDataModel);
    String updateBooking(BookingDataModel bookingDataModel);

    BookingDataModel findByBookingId(String bookingId);

    BookingDataModel findBy(String numberPlate, LocalDateTime start);
}
