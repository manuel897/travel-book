package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.util.MockUtil.resetMock;

class AddBookingTest {
    private static final String DUMMY_USER_ID = "userId";

    BookingRepository mockBookingRepository;
    UserRepository mockUserRepository;
    BookingPresenter mockBookingPresenter;
    AddBooking addBooking;

    @BeforeEach
    void setUp() {
        buildMocks();
        setupMocks();

        addBooking = new AddBooking(
                mockBookingRepository,
                mockUserRepository,
                mockBookingPresenter
        );
    }

    @Test
    @DisplayName("when user is found, booking is created and success is presented")
    void userFound() {
        addBooking.call(TestObjectBuilder.buildNewBookingInput("userId"));

        verify(mockBookingRepository, times(1)).createBooking(any(BookingDataModel.class));
        verify(mockBookingPresenter, times(1)).presentBookingCreated(anyString());
    }

    @Test
    @DisplayName("when user cannot be found, booking cannot be created and a exception is thrown")
    void userNotFound() {
        when(mockUserRepository.findByUsername(anyString())).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,() -> addBooking.call(TestObjectBuilder.buildNewBookingInput(DUMMY_USER_ID)));
    }

    @Test
    @DisplayName("when user has guest role, creating booking is not allowed")
    void userIsGuest() {
        when(mockUserRepository.findByUsername(anyString())).thenReturn(Optional.of(TestObjectBuilder.buildGuestUser(DUMMY_USER_ID)));

        addBooking.call(TestObjectBuilder.buildNewBookingInput(DUMMY_USER_ID));

        verify(mockBookingPresenter, times(1)).presentActionNotAllowed();
    }

    private void buildMocks() {
        mockUserRepository = mock(UserRepository.class);
        mockBookingRepository = mock(BookingRepository.class);
        mockBookingPresenter = mock(BookingPresenter.class);
    }

    private void setupMocks() {
        when(mockUserRepository.findByUsername(anyString())).thenReturn(Optional.of(TestObjectBuilder.buildDriverUser(DUMMY_USER_ID)));
//        when(mockBookingRepository.createBooking(any(BookingDataModel.class))).thenReturn(null);
        doNothing().when(mockBookingPresenter).presentBookingCreated(anyString());
    }

    @AfterEach
    public void reset() {
        resetMock(mockBookingRepository);
        resetMock(mockUserRepository);
    }
}