package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import com.example.domain.user.UserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.util.MockUtil.resetMock;

class UpdateBookingTest {
    BookingRepository mockBookingRepository;
    UserRepository mockUserRepository;
    BookingPresenter mockBookingPresenter;
    UpdateBooking updateBooking;

    @BeforeEach
    void setUp() {
        mockUserRepository = mock(UserRepository.class);
        mockBookingRepository = mock(BookingRepository.class);
        mockBookingPresenter = mock(BookingPresenter.class);

        updateBooking = new UpdateBooking(
                mockBookingRepository,
                mockUserRepository,
                mockBookingPresenter
        );

        when(mockUserRepository.findByUserId(anyString())).thenReturn(buildUserDataModel("U789"));
        when(mockBookingRepository.findByBookingId(anyString())).thenReturn(buildBookingDataModel());
        when(mockBookingRepository.updateBooking(any(BookingDataModel.class))).thenReturn("");
        doNothing().when(mockBookingPresenter).presentBookingCreated(anyString());
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
        updateBooking.call(buildBookingModel());

        verify(mockBookingRepository, times(1)).updateBooking(any(BookingDataModel.class));
        verify(mockBookingPresenter, times(1)).presentBookingUpdated(anyString());
    }

    @Test
    @DisplayName("when user cannot be found, booking cannot be updated and a exception is thrown")
    void userNotFound() {
        when(mockUserRepository.findByUserId(anyString())).thenReturn(null);

        assertThrows(UserNotFoundException.class,() -> updateBooking.call(buildBookingModel()));
    }

    @Test
    @DisplayName("when the booking cannot be found, booking cannot be updated")
    void bookingNotFound() {
        when(mockBookingRepository.findByBookingId(anyString())).thenReturn(null);

        assertThrows(BookingNotFoundException.class,() -> updateBooking.call(buildBookingModel()));
    }

    @Test
    @DisplayName("when the user is the owner of the booking, update is allowed")
    void actionAllowedWhenUserIsOwner() {
        final String sameUser = "JANE";
        final BookingModel bookingModel = buildBookingModel();
        final BookingDataModel existingBooking = buildBookingDataModel();
        existingBooking.setOwnerId(sameUser);
        bookingModel.userId = sameUser;

        when(mockUserRepository.findByUserId(anyString())).thenReturn(buildUserDataModel(sameUser));
        when(mockBookingRepository.findByBookingId(anyString())).thenReturn(existingBooking);

        updateBooking.call(bookingModel);

        verify(mockBookingPresenter, times(1)).presentBookingUpdated(anyString());
    }

    @Test
    @DisplayName("when the user is not the owner of the booking, update is not allowed")
    void actionNotAllowedWhenUserNotOwner() {
        final BookingModel bookingModel = buildBookingModel();
        final BookingDataModel existingBooking = buildBookingDataModel();
        existingBooking.setOwnerId("USER A");
        bookingModel.userId = "USER B";

        when(mockUserRepository.findByUserId(anyString())).thenReturn(buildUserDataModel("USER B"));
        when(mockBookingRepository.findByBookingId(anyString())).thenReturn(existingBooking);

        updateBooking.call(bookingModel);

        verify(mockBookingPresenter, times(0)).presentBookingUpdated(anyString());
        verify(mockBookingPresenter, times(1)).presentActionNotAllowed();
    }

    @Test
    @DisplayName("when the user is not the owner of the booking, update is allowed if the user is a manager")
    void actionAllowedWhenUserNotOwnerButManager() {
        final BookingModel bookingModel = buildBookingModel();
        final BookingDataModel existingBooking = buildBookingDataModel();
        final UserDataModel existingUser = new UserDataModel(
                "USER B",
                "firstName",
                "lastName",
                UserRole.MANAGER.name());
        existingBooking.setOwnerId("USER A");
        bookingModel.userId = "USER B";

        when(mockUserRepository.findByUserId(anyString())).thenReturn(existingUser);
        when(mockBookingRepository.findByBookingId(anyString())).thenReturn(existingBooking);

        updateBooking.call(bookingModel);

        verify(mockBookingPresenter, times(1)).presentBookingUpdated(anyString());
        verify(mockBookingPresenter, times(0)).presentActionNotAllowed();
    }

    private static BookingModel buildBookingModel() {
        BookingModel bookingModel = new BookingModel();

        bookingModel.bookingId = "123";
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

    private static BookingDataModel buildBookingDataModel() {
        BookingDataModel bookingData = new BookingDataModel();
        bookingData.setBookingId("BK123456");
        bookingData.setName("John Doe");
        bookingData.setNotes("This is a test booking.");
        bookingData.setNumberPlate("XYZ 1234");
        bookingData.setDeparture("City A");
        bookingData.setArrival("City B");
        bookingData.setPlannedDistance(150.0);
        bookingData.setUnitOfMeasurement("km");
        bookingData.setStart(LocalDateTime.now().plusDays(1));
        bookingData.setEnd(LocalDateTime.now().plusDays(2));
        bookingData.setBookingStatusId("STATUS_PENDING");
        bookingData.setFirstDriverId("DRIVER_001");
        bookingData.setSecondDriverId("DRIVER_002");
        bookingData.setOwnerId("U789");
        bookingData.setLastModifiedAt(Instant.now());
        bookingData.setInitialQuote(new BigDecimal("250.00"));

        return bookingData;
    }

    private static UserDataModel buildUserDataModel(String userId) {
        return new UserDataModel(
                userId,
                "firstName",
                "lastName",
                "userRole");
    }
}