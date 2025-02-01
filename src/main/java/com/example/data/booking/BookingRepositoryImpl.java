package com.example.data.booking;

import com.example.domain.booking.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class BookingRepositoryImpl  implements BookingRepository {
    final private BookingDataSource bookingDataSource;

    public BookingRepositoryImpl(BookingDataSource bookingDataSource) {
        this.bookingDataSource = bookingDataSource;
    }

    @Override
    public void createBooking(BookingDataModel booking) {
        bookingDataSource.save(booking);
    }

    @Override
    public String updateBooking(BookingDataModel bookingDataModel) {
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
