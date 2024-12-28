package com.lordstdpa.domain.booking;

import java.time.Instant;
import java.time.LocalDateTime;

public class BookingModel {
    String name;
    String notes;
    String departure;
    String arrival;
    Route route;
    LocalDateTime start;
    LocalDateTime end;
    BookingStatus bookingStatus;
    String firstDriverId;
    String secondDriverId;
    String userId;
    Instant lastModifiedAt;

    public String getUserId() {
        return userId;
    }
}
