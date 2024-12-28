package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;

import java.time.LocalDateTime;

public interface BookingRepository {
    void createBooking(BookingDataModel bookingDataModel);

    void findByBookingId(String bookingId);

    BookingDataModel findBy(String numberPlate, LocalDateTime start);
}
