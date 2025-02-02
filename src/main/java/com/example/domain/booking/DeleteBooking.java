package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.models.booking.BookingInputDto;
import com.example.domain.booking.models.BookingNotFoundException;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteBooking {
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final BookingPresenter bookingPresenter;

    DeleteBooking(
            BookingRepository bookingRepository,
            UserRepository userRepository,
            BookingPresenter bookingPresenter
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.bookingPresenter = bookingPresenter;
    }

    public void call(BookingInputDto bookingModel) {
        final Optional<UserDataModel> actionUser = userRepository.findByUsername(bookingModel.userId);
        if(actionUser.isEmpty()) {
            throw new UserNotFoundException("User id " + bookingModel.userId + " not found");
        }

        final Optional<BookingDataModel> existingBooking = bookingRepository.findByBookingId(bookingModel.bookingId);
        throw new BookingNotFoundException(bookingModel.bookingId.toString());

        // only owner or manager can delete booking
    }
}