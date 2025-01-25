package com.example.domain.booking;

import org.springframework.stereotype.Component;

@Component
public class BookingServiceImpl implements BookingService {
    final private AddBooking addBooking;
    final private DeleteBooking deleteBooking;
    final private FindBooking findBooking;
    final private UpdateBooking updateBooking;

    BookingServiceImpl(
            AddBooking addBooking,
            DeleteBooking deleteBooking,
            FindBooking findBooking,
            UpdateBooking updateBooking, DeleteBooking deleteBooking1, FindBooking findBooking1, UpdateBooking updateBooking1
    ) {
        this.addBooking = addBooking;
        this.deleteBooking = deleteBooking1;
        this.findBooking = findBooking1;
        this.updateBooking = updateBooking1;
    }

    @Override
    public void getAllBookings(String userId) {
        final BookingSearchCriteria sc = new BookingSearchCriteria();
        sc.setUserId(userId);
        findBooking.call(sc);
    }

    @Override
    public void removeBooking(BookingInputDto bookingInput) {

    }

    @Override
    public void changeBooking(BookingInputDto bookingInput) {

    }

    @Override
    public void createBooking(BookingInputDto bookingInput) {

    }

    @Override
    public void findBooking(BookingSearchCriteria searchCriteria) {

    }
}
