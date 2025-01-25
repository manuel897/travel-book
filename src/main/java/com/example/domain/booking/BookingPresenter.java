package com.example.domain.booking;

import java.util.List;

public interface BookingPresenter {
    void presentBookingCreated(String createdBookingId);
    void presentBookingUpdated(String updatedBookingId);
    void presentBookingDeleted(String updatedBookingId);
    void presentActionNotAllowed();
    void presentInvalidInput();
    void presentBookingsFound(List<BookingDto> bookingList);
}
