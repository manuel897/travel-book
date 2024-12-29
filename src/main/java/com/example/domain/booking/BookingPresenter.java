package com.example.domain.booking;

public interface BookingPresenter {
    void presentBookingCreated(String createdBookingId);
    void presentBookingUpdated(String updatedBookingId);
    void presentActionNotAllowed();
}
