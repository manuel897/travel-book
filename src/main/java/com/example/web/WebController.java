package com.example.web;

import com.example.controller.BookingController;
import com.example.controller.BookingControllerImpl;
import com.example.controller.UserController;
import com.example.models.booking.BookingDto;
import com.example.models.booking.BookingInputDto;
import com.example.models.user.UserInputDto;
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
    private final BookingHttpResponseBuilder bookingResponseBuilder;
    private final UserController userController;
    private final UserHttpResponseBuilder userReponseBuilder;

    public WebController(BookingControllerImpl bookingController, BookingHttpResponseBuilder bookingReponseBuilder, UserController userController, BookingHttpResponseBuilder bookingReponseBuilder1, UserHttpResponseBuilder yserReponseBuilder) {
        this.bookingController = bookingController;
        this.bookingResponseBuilder = bookingReponseBuilder;
        this.userController = userController;
        this.userReponseBuilder = yserReponseBuilder;
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDto>> getBookings() {
        bookingController.onGetAllBooking("mialu23");
        return bookingResponseBuilder.getBookingResponse();
    }

    @PostMapping(path = "/booking", consumes = "application/json")
    public ResponseEntity<String> newBooking(@RequestBody BookingInputDto bookingModel) {
        bookingController.onNewBooking(bookingModel);
        return bookingResponseBuilder.getStringResponse();
    }

    @PostMapping(path = "/user", consumes = "application/json")
    public ResponseEntity<String> newUser(@RequestBody UserInputDto userInput) {
        userController.onCreateUser(userInput);
        return userReponseBuilder.getStringResponse();
    }
}

