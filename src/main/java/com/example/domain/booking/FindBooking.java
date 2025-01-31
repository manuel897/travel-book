package com.example.domain.booking;

import com.example.data.booking.BookingDataModel;
import com.example.data.user.UserDataModel;
import com.example.models.booking.BookingDto;
import com.example.models.booking.BookingSearchCriteria;
import com.example.domain.user.UserNotFoundException;
import com.example.domain.user.UserRepository;
import com.example.models.booking.BookingStatusConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class FindBooking {
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final BookingPresenter bookingPresenter;
    private final BookingStatusConverter bookingStatusConverter = new BookingStatusConverter();

    FindBooking(
            BookingRepository bookingRepository,
            UserRepository userRepository,
            BookingPresenter bookingPresenter, UserRepository userRepository1, BookingRepository bookingRepository1, BookingPresenter bookingPresenter1
    ) {
        this.userRepository = userRepository1;
        this.bookingRepository = bookingRepository1;
        this.bookingPresenter = bookingPresenter1;
    }

    public void call(BookingSearchCriteria searchCriteria) {
        final Optional<UserDataModel> existingUser = userRepository.findByUsername(searchCriteria.userId);
        if(existingUser.isEmpty()) {
            throw new UserNotFoundException("User id " + searchCriteria.userId + " not found");
        }

        if(searchCriteria.bookingId == null) {
            final List<BookingDataModel> bookingList = bookingRepository.findAll();
            final List<BookingDto> result = new ArrayList<>();
            for(BookingDataModel b : bookingList) {
                result.add(createDtoFromFoundBooking(b));
            }

            bookingPresenter.presentBookingsFound(result);
            return;
        }

        final Optional<BookingDataModel> booking = bookingRepository.findByBookingId(searchCriteria.bookingId);
        if(booking.isEmpty()) {
            bookingPresenter.presentBookingsFound(List.of());
            return;
        }

        final BookingDto dto = createDtoFromFoundBooking(booking.get());

        final List<BookingDto> result = Collections.singletonList(dto);
        bookingPresenter.presentBookingsFound(result);
    }

    private BookingDto createDtoFromFoundBooking(BookingDataModel booking) {
        final BookingDto dto = new BookingDto();

        if (booking.getNumberPlate() != null) {
            dto.setNumberPlate(booking.getNumberPlate());
        }
        if (booking.getName() != null) {
            dto.setName(booking.getName());
        }
        if (booking.getNotes() != null) {
            dto.setNotes(booking.getNotes());
        }
        if (booking.getDeparture() != null) {
            dto.setDeparture(booking.getDeparture());
        }
        if (booking.getArrival() != null) {
            dto.setArrival(booking.getArrival());
        }
        if (booking.getPlannedDistance() != null) {
            dto.setDistance(booking.getPlannedDistance());
        }
        if (booking.getStartTime() != null) {
            dto.setStart(booking.getStartTime());
        }
        if (booking.getFinishTime() != null) {
            dto.setEnd(booking.getFinishTime());
        }

        dto.setBookingStatus(bookingStatusConverter.toEntity(booking.getBookingStatusId()));

        if (booking.getFirstDriverUsername() != null) {
            dto.setFirstDriverId(booking.getFirstDriverUsername());
        }
        if (booking.getSecondDriverUsername() != null) {
            dto.setSecondDriverId(booking.getSecondDriverUsername());
        }
        if (booking.getOwnerUsername() != null) {
            dto.setUserId(booking.getOwnerUsername());
        }
        if (booking.getLastModifiedAt() != null) {
            dto.setLastModifiedAt(booking.getLastModifiedAt());
        }
        if (booking.getInitialQuote() != null) {
            dto.setInitialQuote(booking.getInitialQuote());
        }

        return dto;
    }
}

