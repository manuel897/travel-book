package com.lordstdpa.domain.booking;

import com.lordstdpa.domain.user.Driver;
import com.lordstdpa.domain.user.User;

import java.time.Instant;
import java.time.LocalDateTime;

public class Booking {
    String name;
    String notes;
    Route route;
    LocalDateTime start;
    LocalDateTime end;
    BookingStatus bookingStatus;
    Driver firstDriver;
    Driver secondDriver;
    User createdBy;
    Instant lastModifiedAt;
}
