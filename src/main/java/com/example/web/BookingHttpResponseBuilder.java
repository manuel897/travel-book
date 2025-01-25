package com.example.web;

import com.example.domain.booking.BookingDto;
import com.example.domain.booking.BookingPresenter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingHttpResponseBuilder implements BookingPresenter {
    private ResponseEntity<List<BookingDto>> response;

    @Override
    public void presentBookingCreated(String createdBookingId) {
        setDummyResponse();
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
        response = createResponse(bookingList);
    }

    private ResponseEntity<List<BookingDto>> createResponse(List<BookingDto> dto) {
        return new ResponseEntity<>(dto, HttpStatusCode.valueOf(200));
    }

    private void setDummyResponse() {
        response = new ResponseEntity<>(List.of() , HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<List<BookingDto>> getResponse() {
        return response;
    }
}
