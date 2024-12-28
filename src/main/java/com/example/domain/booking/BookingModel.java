package com.example.domain.booking;

import java.time.Instant;
import java.time.LocalDateTime;

public class BookingModel {
    String numberPlate;
    String name;
    String notes;
    String departure;
    String arrival;
    Double distance;
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

    public String getNumberPlate() {
        return numberPlate;
    }

    public LocalDateTime getStart() {
        return start;
    }
}
