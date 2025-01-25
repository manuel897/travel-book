package com.example.domain.booking;

public interface BookingService {
    void changeBooking(BookingInputDto bookingInput);

    void createBooking(BookingInputDto bookingInput);

    void findBooking(BookingSearchCriteria searchCriteria);

    void getAllBookings(String userId);

    void removeBooking(BookingInputDto bookingInput);
}
