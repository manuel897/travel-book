package com.example.domain.booking;

public interface BookingPresenter {
    void presentBookingCreated(String createdBookingId);
    void presentBookingUpdated(String updatedBookingId);
    void presentBookingDeleted(String updatedBookingId);
    void presentActionNotAllowed();
}
