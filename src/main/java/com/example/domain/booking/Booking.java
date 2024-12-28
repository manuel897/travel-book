package com.example.domain.booking;

import com.example.domain.user.Driver;
import com.example.domain.user.User;
import com.example.domain.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public class Booking {
    String name;
    Vehicle vehicle;
    String notes;
    Route route;
    LocalDateTime start;
    LocalDateTime end;
    BookingStatus bookingStatus;
    Driver firstDriver;
    Driver secondDriver;
    User createdBy;
    Instant lastModifiedAt;
    BigDecimal initialQuote;
}
