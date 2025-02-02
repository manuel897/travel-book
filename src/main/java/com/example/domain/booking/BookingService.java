package com.example.domain.booking;

import com.example.models.booking.BookingInputDto;
import com.example.models.booking.BookingSearchCriteria;

public interface BookingService {
    void changeBooking(BookingInputDto bookingInput);

    void createBooking(BookingInputDto bookingInput);

    void findBooking(BookingSearchCriteria searchCriteria);

    void getAllBookings();

    void getBookingsOfUser(String username);

    void removeBooking(BookingInputDto bookingInput);
}
