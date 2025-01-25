package com.example.domain.booking;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public class BookingDto {
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

    // Getters
    public String getNumberPlate() {
        return numberPlate;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public Double getDistance() {
        return distance;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public String getFirstDriverId() {
        return firstDriverId;
    }

    public String getSecondDriverId() {
        return secondDriverId;
    }

    public String getUserId() {
        return userId;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }

    public BigDecimal getInitialQuote() {
        return initialQuote;
    }

    // Setters
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setFirstDriverId(String firstDriverId) {
        this.firstDriverId = firstDriverId;
    }

    public void setSecondDriverId(String secondDriverId) {
        this.secondDriverId = secondDriverId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public void setInitialQuote(BigDecimal initialQuote) {
        this.initialQuote = initialQuote;
    }
}
