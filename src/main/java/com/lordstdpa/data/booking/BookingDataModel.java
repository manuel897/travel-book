package com.lordstdpa.data.booking;

import java.time.Instant;
import java.time.LocalDateTime;

public class BookingDataModel {
    String bookingId;
    String name;
    String notes;
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

    public BookingDataModel(
            String bookingId,
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
            Instant lastModifiedAt
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
    }
}
