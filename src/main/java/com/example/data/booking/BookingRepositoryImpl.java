package com.example.data.booking;

import com.example.domain.booking.BookingRepository;
import com.example.domain.booking.BookingStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Component
public class BookingRepositoryImpl  implements BookingRepository {
    @Override
    public String createBooking(BookingDataModel bookingDataModel) {
        return "";
    }

    @Override
    public String updateBooking(BookingDataModel bookingDataModel) {
        return "";
    }

    @Override
    public BookingDataModel findByBookingId(String bookingId) {
        return null;
    }

    @Override
    public List<BookingDataModel> findAll() {
        // TODO remove hardcoded values
        final BookingDataModel sampleBooking = new BookingDataModel(
                "booking_id",
                "AB 12 3456",
                "Chruch Tour",
                "A trip from a local church",
                "Location Departure",
                "Location Arrival",
                "KM",
                100.5,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "0",
                "Driver A",
                "Driver B",
                "Owner A",
                Instant.now(),
                BigDecimal.valueOf(5000)
        );

        return Collections.singletonList(sampleBooking);
    }

    @Override
    public BookingDataModel deleteBooking(String bookingId) {
        return null;
    }
}
