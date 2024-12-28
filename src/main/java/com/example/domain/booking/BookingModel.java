package com.example.domain.booking;

import java.math.BigDecimal;
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
    BigDecimal initialQuote;
}
