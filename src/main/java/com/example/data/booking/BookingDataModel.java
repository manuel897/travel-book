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

    public BookingDataModel() {}

    public String getBookingStatusId() {
        return bookingStatusId;
    }

    public void setBookingStatusId(String bookingStatusId) {
        this.bookingStatusId = bookingStatusId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Double getPlannedDistance() {
        return plannedDistance;
    }

    public void setPlannedDistance(Double plannedDistance) {
        this.plannedDistance = plannedDistance;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getFirstDriverId() {
        return firstDriverId;
    }

    public void setFirstDriverId(String firstDriverId) {
        this.firstDriverId = firstDriverId;
    }

    public String getSecondDriverId() {
        return secondDriverId;
    }

    public void setSecondDriverId(String secondDriverId) {
        this.secondDriverId = secondDriverId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public BigDecimal getInitialQuote() {
        return initialQuote;
    }

    public void setInitialQuote(BigDecimal initialQuote) {
        this.initialQuote = initialQuote;
    }

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
