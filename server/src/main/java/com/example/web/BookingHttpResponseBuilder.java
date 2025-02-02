package com.example.web;

import com.example.models.booking.BookingDto;
import com.example.domain.booking.BookingPresenter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingHttpResponseBuilder implements BookingPresenter {
    private ResponseEntity<List<BookingDto>> bookingResponse;
    private ResponseEntity<String> stringResponse;

    @Override
    public void presentBookingCreated(String name) {
        stringResponse = createStringResponse("Booking " + name + " created");
    }

    @Override
    public void presentBookingUpdated(String updatedBookingId) {
        setDummyResponse();
    }

    @Override
    public void presentBookingDeleted(String updatedBookingId) {
        setDummyResponse();
    }

    @Override
    public void presentActionNotAllowed() {
        setDummyResponse();
    }

    @Override
    public void presentInvalidInput() {
        setDummyResponse();
    }

    @Override
    public void presentBookingsFound(List<BookingDto> bookingList) {
        bookingResponse = createResponse(bookingList);
    }

    private ResponseEntity<List<BookingDto>> createResponse(List<BookingDto> dto) {
        return new ResponseEntity<>(dto, HttpStatusCode.valueOf(200));
    }

    private ResponseEntity<String> createStringResponse(String message) {
        return new ResponseEntity<>(message, HttpStatusCode.valueOf(200));
    }

    private void setDummyResponse() {
        bookingResponse = new ResponseEntity<>(List.of() , HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<List<BookingDto>> getBookingResponse() {
        return bookingResponse;
    }

    public ResponseEntity<String> getStringResponse() {
        return stringResponse;
    }
}
