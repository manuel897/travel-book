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
        final UserDataModel existingUser = userRepository.findByUsername(searchCriteria.userId);
        if(existingUser == null) {
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

        final BookingDataModel booking = bookingRepository.findByBookingId(searchCriteria.bookingId);
        final BookingDto dto = createDtoFromFoundBooking(booking);

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
        if (booking.getStart() != null) {
            dto.setStart(booking.getStart());
        }
        if (booking.getEnd() != null) {
            dto.setEnd(booking.getEnd());
        }

        dto.setBookingStatus(bookingStatusConverter.toEntity(booking.getBookingStatusId()));

        if (booking.getFirstDriverId() != null) {
            dto.setFirstDriverId(booking.getFirstDriverId());
        }
        if (booking.getSecondDriverId() != null) {
            dto.setSecondDriverId(booking.getSecondDriverId());
        }
        if (booking.getOwnerId() != null) {
            dto.setUserId(booking.getOwnerId());
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

