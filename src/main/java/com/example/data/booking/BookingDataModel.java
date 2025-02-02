package com.example.data.booking;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Table("booking")
public class BookingDataModel {
    @Id
    Integer bookingId;
    String name;
    String notes;
    String numberPlate;
    String departure;
    String arrival;
    Double plannedDistance;
    String unitOfMeasurement;
    LocalDateTime startTime;
    LocalDateTime finishTime;
    int bookingStatusId;
    String firstDriverUsername;
    String secondDriverUsername;
    String ownerUsername;
    Instant lastModifiedAt;
    BigDecimal initialQuote;

    public BookingDataModel() {}

    public int getBookingStatusId() {
        return bookingStatusId;
    }

    public void setBookingStatusId(int bookingStatusId) {
        this.bookingStatusId = bookingStatusId;
    }

    public Integer getBookingId() {
        return bookingId;
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

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public String getFirstDriverUsername() {
        return firstDriverUsername;
    }

    public void setFirstDriverUsername(String firstDriverUsername) {
        this.firstDriverUsername = firstDriverUsername;
    }

    public String getSecondDriverUsername() {
        return secondDriverUsername;
    }

    public void setSecondDriverUsername(String secondDriverUsername) {
        this.secondDriverUsername = secondDriverUsername;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
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

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public BookingDataModel(
            String numberPlate,
            String name,
            String notes,
            String departure,
            String arrival,
            String unitOfMeasurement,
            Double plannedDistance,
            LocalDateTime startTime,
            LocalDateTime finishTime,
            int bookingStatusId,
            String firstDriverUsername,
            String secondDriverUsername,
            String ownerUsername,
            Instant lastModifiedAt,
            BigDecimal initialQuote
    ) {
        this.numberPlate = numberPlate;
        this.name = name;
        this.notes = notes;
        this.departure = departure;
        this.arrival = arrival;
        this.unitOfMeasurement = unitOfMeasurement;
        this.plannedDistance = plannedDistance;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.bookingStatusId = bookingStatusId;
        this.firstDriverUsername = firstDriverUsername;
        this.secondDriverUsername = secondDriverUsername;
        this.ownerUsername = ownerUsername;
        this.lastModifiedAt = lastModifiedAt;
        this.initialQuote = initialQuote;
    }
}

