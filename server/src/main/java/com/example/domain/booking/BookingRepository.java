package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    void createBooking(BookingDataModel booking);
    String updateBooking(BookingDataModel bookingDataModel);
    Optional<BookingDataModel> findByBookingId(Integer bookingId);
    List<BookingDataModel> findAll();
    void deleteBooking(Integer bookingId);
}
