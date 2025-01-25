package com.example.models.booking;

import com.example.domain.booking.models.BookingStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public class BookingInputDto {
    public String bookingId;
    public String numberPlate;
    public String name;
    public String notes;
    public String departure;
    public String arrival;
    public Double distance;
    public LocalDateTime start;
    public LocalDateTime end;
    public int statusCode;
    public String firstDriverId;
    public String secondDriverId;
    public String userId;
    public BigDecimal initialQuote;
}
