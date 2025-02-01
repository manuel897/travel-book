package com.example.data.booking;

import com.example.domain.booking.BookingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class BookingRepositoryImpl  implements BookingRepository {
    private static final Logger LOGGER = LogManager.getLogger();

    final private BookingDataSource bookingDataSource;

    public BookingRepositoryImpl(BookingDataSource bookingDataSource) {
        this.bookingDataSource = bookingDataSource;
    }

    @Override
    public void createBooking(BookingDataModel booking) {
        LOGGER.info("Creating booking with name `{}` by {}", booking.name, booking.ownerUsername);
        bookingDataSource.save(booking);
    }

    @Override
    public String updateBooking(BookingDataModel booking) {
        LOGGER.info("Update booking with name `{}` by {}", booking.name, booking.ownerUsername);
        return "Update not yet implemented! No Data available";
    }

    @Override
    public Optional<BookingDataModel> findByBookingId(Integer bookingId) {
        return bookingDataSource.findById(bookingId);
    }

    @Override
    public List<BookingDataModel> findAll() {
        return (List<BookingDataModel>) bookingDataSource.findAll();
    }

    @Override
    public void deleteBooking(Integer bookingId) {
        bookingDataSource.deleteById(bookingId);
    }
}
