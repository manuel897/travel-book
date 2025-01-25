package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;

import java.util.List;

public interface BookingRepository {
    String createBooking(BookingDataModel bookingDataModel);
    String updateBooking(BookingDataModel bookingDataModel);
    BookingDataModel findByBookingId(String bookingId);
    List<BookingDataModel> findAll();
    BookingDataModel deleteBooking(String bookingId);
}
