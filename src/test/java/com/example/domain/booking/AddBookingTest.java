package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.util.MockUtil.resetMock;

class AddBookingTest {
    BookingRepository mockBookingRepository;
    UserRepository mockUserRepository;
    BookingPresenter mockBookingPresenter;
    AddBooking addBooking;

    @BeforeEach
    void setUp() {
        mockUserRepository = mock(UserRepository.class);
        mockBookingRepository = mock(BookingRepository.class);
        mockBookingPresenter = mock(BookingPresenter.class);

        addBooking = new AddBooking(
                mockBookingRepository,
                mockUserRepository,
                mockBookingPresenter
        );

        final UserDataModel dummyUser = new UserDataModel(
        "userId",
        "firstName",
        "lastName",
        "userRole");

        when(mockUserRepository.findByUserId(anyString())).thenReturn(dummyUser);
        when(mockBookingRepository.createBooking(any(BookingDataModel.class))).thenReturn("");
        doNothing().when(mockBookingPresenter).presentBookingCreated(anyString());
    }

    @AfterEach
    public void reset() {
        resetMock(mockBookingRepository);
        resetMock(mockUserRepository);
    }

    @Test
    @DisplayName("when user is found, booking is created and success is presented")
    void userFound() {
        addBooking.call(buildBookingModel());

        verify(mockBookingRepository, times(1)).createBooking(any(BookingDataModel.class));
        verify(mockBookingPresenter, times(1)).presentBookingCreated(anyString());
    }

    @Test
    @DisplayName("when user cannot be found, booking cannot be created and a exception is thrown")
    void userNotFound() {
        when(mockUserRepository.findByUserId(anyString())).thenReturn(null);

        assertThrows(UserNotFoundException.class,() -> addBooking.call(buildBookingModel()));
    }

    private static BookingModel buildBookingModel() {
        BookingModel bookingModel = new BookingModel();

        bookingModel.numberPlate = "ABC123";
        bookingModel.name = "John Doe";
        bookingModel.notes = "This is a dummy booking.";
        bookingModel.departure = "New York";
        bookingModel.arrival = "Los Angeles";
        bookingModel.distance = 4500.0; // Distance in kilometers
        bookingModel.start = LocalDateTime.of(2024, 1, 1, 8, 30); // Jan 1, 2024, 8:30 AM
        bookingModel.end = LocalDateTime.of(2024, 1, 5, 20, 0); // Jan 5, 2024, 8:00 PM
        bookingModel.bookingStatus = BookingStatus.ENQUIRY;
        bookingModel.firstDriverId = "D123";
        bookingModel.secondDriverId = "D456";
        bookingModel.userId = "U789";
        bookingModel.lastModifiedAt = Instant.now(); // Current timestamp
        bookingModel.initialQuote = BigDecimal.valueOf(1000.00); // Example quote in USD

        return bookingModel;
    }
}