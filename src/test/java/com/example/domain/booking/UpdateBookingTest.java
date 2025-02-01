package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.models.booking.BookingInputDto;
import com.example.domain.booking.models.BookingNotFoundException;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.util.MockUtil.resetMock;

class UpdateBookingTest {
    private static final String DUMMY_USER_ID = "userId";
    private static final Integer DUMMY_BOOKING_ID = 101;

    BookingRepository mockBookingRepository;
    UserRepository mockUserRepository;
    BookingPresenter mockBookingPresenter;
    UpdateBooking updateBooking;

    @BeforeEach
    void setUp() {
        buildMocks();
        setupMocks();

        updateBooking = new UpdateBooking(
                mockBookingRepository,
                mockUserRepository,
                mockBookingPresenter
        );
    }

    private void setupMocks() {
        when(mockUserRepository.findByUsername(anyString())).thenReturn(Optional.of(TestObjectBuilder.buildDriverUser(DUMMY_USER_ID)));
        when(mockBookingRepository.findByBookingId(any())).thenReturn(Optional.of(TestObjectBuilder.buildBookingDataModel()));
        when(mockBookingRepository.updateBooking(any(BookingDataModel.class))).thenReturn("");
        doNothing().when(mockBookingPresenter).presentBookingCreated(anyString());
    }

    private void buildMocks() {
        mockUserRepository = mock(UserRepository.class);
        mockBookingRepository = mock(BookingRepository.class);
        mockBookingPresenter = mock(BookingPresenter.class);
    }

    @AfterEach
    public void reset() {
        resetMock(mockBookingRepository);
        resetMock(mockUserRepository);
        resetMock(mockBookingPresenter);
    }

    @Test
    @DisplayName("when user and booking is found, booking is updated and success is presented")
    void userFound() {
        final BookingDataModel existingBooking = TestObjectBuilder.buildBookingDataModel();
        existingBooking.setOwnerUsername(DUMMY_USER_ID);
        when(mockBookingRepository.findByBookingId(any())).thenReturn(Optional.of(existingBooking));

        updateBooking.call(TestObjectBuilder.buildExistingBookingInput(DUMMY_BOOKING_ID ,DUMMY_USER_ID));

        verify(mockBookingRepository, times(1)).updateBooking(any(BookingDataModel.class));
        verify(mockBookingPresenter, times(1)).presentBookingUpdated(anyString());
    }

    @Test
    @DisplayName("when user cannot be found, booking cannot be updated and a exception is thrown")
    void userNotFound() {
        when(mockUserRepository.findByUsername(anyString())).thenReturn(null);

        assertThrows(UserNotFoundException.class,() -> updateBooking.call(TestObjectBuilder.buildNewBookingInput(DUMMY_USER_ID)));
    }

    @Test
    @DisplayName("when the booking cannot be found, booking cannot be updated")
    void bookingNotFound() {
        when(mockBookingRepository.findByBookingId(any())).thenReturn(null);

        assertThrows(BookingNotFoundException.class,() -> updateBooking.call(TestObjectBuilder.buildNewBookingInput(DUMMY_USER_ID)));
    }

    @Test
    @DisplayName("when the user is the owner of the booking, update is allowed")
    void actionAllowedWhenUserIsOwner() {
        final String sameUser = "JANE";
        final BookingDataModel existingBooking = TestObjectBuilder.buildBookingDataModel();
        existingBooking.setOwnerUsername(sameUser);
        when(mockUserRepository.findByUsername(anyString())).thenReturn(Optional.of(TestObjectBuilder.buildDriverUser(sameUser)));
        when(mockBookingRepository.findByBookingId(any())).thenReturn(Optional.of(existingBooking));

        updateBooking.call(TestObjectBuilder.buildExistingBookingInput(DUMMY_BOOKING_ID, sameUser));

        verify(mockBookingPresenter, times(1)).presentBookingUpdated(anyString());
    }

    @Test
    @DisplayName("when the user is not the owner of the booking, update is not allowed")
    void actionNotAllowedWhenUserNotOwner() {
        final BookingInputDto bookingModel = TestObjectBuilder.buildExistingBookingInput(DUMMY_BOOKING_ID, DUMMY_USER_ID);
        final BookingDataModel existingBooking = TestObjectBuilder.buildBookingDataModel();
        existingBooking.setOwnerUsername("USER A");
        bookingModel.userId = "USER B";

        when(mockUserRepository.findByUsername(anyString())).thenReturn(Optional.of(TestObjectBuilder.buildDriverUser("USER B")));
        when(mockBookingRepository.findByBookingId(any())).thenReturn(Optional.of(existingBooking));

        updateBooking.call(bookingModel);

        verify(mockBookingPresenter, times(0)).presentBookingUpdated(anyString());
        verify(mockBookingPresenter, times(1)).presentActionNotAllowed();
    }

    @Test
    @DisplayName("when the user is not the owner of the booking, update is allowed if the user is a manager")
    void actionAllowedWhenUserNotOwnerButManager() {
        final String managerUserId = "MANAGER";
        final BookingInputDto bookingInput = TestObjectBuilder.buildExistingBookingInput(DUMMY_BOOKING_ID, managerUserId);
        final BookingDataModel existingBooking = TestObjectBuilder.buildBookingDataModel();

        existingBooking.setOwnerUsername("USER A");

        when(mockUserRepository.findByUsername(anyString())).thenReturn(Optional.of(TestObjectBuilder.buildManagerUser(managerUserId)));
        when(mockBookingRepository.findByBookingId(any())).thenReturn(Optional.of(existingBooking));

        updateBooking.call(bookingInput);

        verify(mockBookingPresenter, times(1)).presentBookingUpdated(anyString());
        verify(mockBookingPresenter, times(0)).presentActionNotAllowed();
    }
}