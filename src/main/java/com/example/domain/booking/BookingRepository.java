package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;

public interface BookingRepository {
    String createBooking(BookingDataModel bookingDataModel);
    String updateBooking(BookingDataModel bookingDataModel);
    BookingDataModel findByBookingId(String bookingId);
    BookingDataModel deleteBooking(String bookingId);
}
