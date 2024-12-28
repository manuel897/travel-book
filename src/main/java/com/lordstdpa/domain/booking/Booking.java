package com.lordstdpa.domain.booking;

import com.lordstdpa.data.booking.BookingDataModel;
import com.lordstdpa.data.user.UserDataModel;
import com.lordstdpa.domain.user.Driver;
import com.lordstdpa.domain.user.User;
import com.lordstdpa.domain.user.UserNotFoundException;
import com.lordstdpa.domain.user.UserRepository;
import com.lordstdpa.domain.vehicle.Vehicle;

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
}
