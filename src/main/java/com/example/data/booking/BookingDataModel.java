package com.example.data.booking;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public class BookingDataModel {
    String bookingId;
    String name;
    String notes;
    String numberPlate;
    String departure;
    String arrival;
    Double plannedDistance;
    String unitOfMeasurement;
    LocalDateTime start;
    LocalDateTime end;
    String bookingStatusId;
    String firstDriverId;
    String secondDriverId;
    String ownerId;
    Instant lastModifiedAt;
    BigDecimal initialQuote;

    public BookingDataModel(
            String bookingId,
            String numberPlate,
            String name,
            String notes,
            String departure,
            String arrival,
            String unitOfMeasurement,
            Double plannedDistance,
            LocalDateTime start,
            LocalDateTime end,
            String bookingStatusId,
            String firstDriverId,
            String secondDriverId,
            String ownerId,
            Instant lastModifiedAt,
            BigDecimal initialQuote
    ) {
        this.bookingId = bookingId;
        this.name = name;
        this.notes = notes;
        this.departure = departure;
        this.arrival = arrival;
        this.unitOfMeasurement = unitOfMeasurement;
        this.plannedDistance = plannedDistance;
        this.start = start;
        this.end = end;
        this.bookingStatusId = bookingStatusId;
        this.firstDriverId = firstDriverId;
        this.secondDriverId = secondDriverId;
        this.ownerId = ownerId;
        this.lastModifiedAt = lastModifiedAt;
        this.initialQuote = initialQuote;
    }
}
