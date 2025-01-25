package com.example.web;

import com.example.controller.BookingController;
import com.example.controller.BookingControllerImpl;
import com.example.domain.booking.BookingDto;
import com.example.domain.booking.BookingInputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController
{
    private final BookingController bookingController;
    private final BookingHttpResponseBuilder bookingReponseBuilder;

    public WebController(BookingControllerImpl bookingController, BookingHttpResponseBuilder bookingReponseBuilder) {
        this.bookingController = bookingController;
        this.bookingReponseBuilder = bookingReponseBuilder;
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDto>> getBookings() {
        bookingController.onGetAllBooking("mialu23");
        return bookingReponseBuilder.getResponse();
    }

    @PostMapping(path = "/booking", consumes = "application/json")
    public ResponseEntity<List<BookingDto>> processPost(@RequestBody BookingInputDto bookingModel) {
//        bookingController.on(bookingModel);
        return bookingReponseBuilder.getResponse();
    }
}
