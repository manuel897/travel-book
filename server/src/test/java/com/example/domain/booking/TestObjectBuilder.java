package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.models.booking.BookingInputDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public class TestObjectBuilder {
    private static final int MANAGER_ROLE_ID = 0;
    private static final int DRIVER_ROLE_ID = 1;
    private static final int GUEST_ROLE_ID = 2;

    public static UserDataModel buildDriverUser(String userId) {
        return new UserDataModel(
                userId,
                "hash",
                "firstName",
                "lastName",
                DRIVER_ROLE_ID);
    }

    public static UserDataModel buildManagerUser(String userId) {
        return new UserDataModel(
                userId,
                "hash",
                "firstName",
                "lastName",
                MANAGER_ROLE_ID);
    }

    static UserDataModel buildGuestUser(
            String userId
    ) {
        return new UserDataModel(
                userId,
                "hash",
                "firstName",
                "lastName",
                GUEST_ROLE_ID);
    }

    static BookingInputDto buildNewBookingInput(String userId) {
        BookingInputDto dto = new BookingInputDto();

        dto.numberPlate = "ABC123";
        dto.name = "John Doe";
        dto.notes = "This is a dummy booking.";
        dto.departure = "New York";
        dto.arrival = "Los Angeles";
        dto.distance = 4500.0; // Distance in kilometers
        dto.start = LocalDateTime.of(2024, 1, 1, 8, 30); // Jan 1, 2024, 8:30 AM
        dto.end = LocalDateTime.of(2024, 1, 5, 20, 0); // Jan 5, 2024, 8:00 PM
        dto.bookingId = 0;
        dto.firstDriverId = "D123";
        dto.secondDriverId = "D456";
        dto.userId = userId;
        dto.initialQuote = BigDecimal.valueOf(1000.00); // Example quote in USD

        return dto;
    }

    static BookingInputDto buildExistingBookingInput(Integer bookingId, String userId) {
        BookingInputDto dto = new BookingInputDto();

        dto.bookingId = bookingId;
        dto.numberPlate = "ABC123";
        dto.name = "John Doe";
        dto.notes = "This is a dummy booking.";
        dto.departure = "New York";
        dto.arrival = "Los Angeles";
        dto.distance = 4500.0; // Distance in kilometers
        dto.start = LocalDateTime.of(2024, 1, 1, 8, 30); // Jan 1, 2024, 8:30 AM
        dto.end = LocalDateTime.of(2024, 1, 5, 20, 0); // Jan 5, 2024, 8:00 PM
        dto.statusCode = 0;
        dto.firstDriverId = "D123";
        dto.secondDriverId = "D456";
        dto.userId = userId;
        dto.initialQuote = BigDecimal.valueOf(1000.00); // Example quote in USD

        return dto;
    }

    static BookingInputDto buildExistingBookingInputWithOwner(Integer bookingId, String userId, String ownerId) {
        BookingInputDto dto = new BookingInputDto();

        dto.bookingId = bookingId;
        dto.numberPlate = "ABC123";
        dto.name = "John Doe";
        dto.notes = "This is a dummy booking.";
        dto.departure = "New York";
        dto.arrival = "Los Angeles";
        dto.distance = 4500.0; // Distance in kilometers
        dto.start = LocalDateTime.of(2024, 1, 1, 8, 30); // Jan 1, 2024, 8:30 AM
        dto.end = LocalDateTime.of(2024, 1, 5, 20, 0); // Jan 5, 2024, 8:00 PM
        dto.statusCode = 0;
        dto.firstDriverId = "D123";
        dto.secondDriverId = "D456";
        dto.userId = userId;
        dto.initialQuote = BigDecimal.valueOf(1000.00); // Example quote in USD

        return dto;
    }

    static BookingDataModel buildBookingDataModel() {
        BookingDataModel bookingData = new BookingDataModel();
        bookingData.setBookingId(123456);
        bookingData.setName("John Doe");
        bookingData.setNotes("This is a test booking.");
        bookingData.setNumberPlate("XYZ 1234");
        bookingData.setDeparture("City A");
        bookingData.setArrival("City B");
        bookingData.setPlannedDistance(150.0);
        bookingData.setUnitOfMeasurement("km");
        bookingData.setStartTime(LocalDateTime.now().plusDays(1));
        bookingData.setFinishTime(LocalDateTime.now().plusDays(2));
        bookingData.setBookingStatusId(1);
        bookingData.setFirstDriverUsername("DRIVER_001");
        bookingData.setSecondDriverUsername("DRIVER_002");
        bookingData.setOwnerUsername("U789");
        bookingData.setLastModifiedAt(Instant.now());
        bookingData.setInitialQuote(new BigDecimal("250.00"));

        return bookingData;
    }
}
