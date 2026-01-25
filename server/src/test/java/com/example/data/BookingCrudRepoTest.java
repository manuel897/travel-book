package com.example.data;

import com.example.AppConfig;
import com.example.RestServiceApplication;
import com.example.data.booking.BookingDataSource;
import com.example.data.booking.BookingDataModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestServiceApplication.class)
@Transactional
//@ContextConfiguration(classes = AppConfig.class)
public class BookingCrudRepoTest {
    @Autowired
    BookingDataSource bookingCrudRepo;

    @Test
    void createSimpleBooking() {
        BookingDataModel booking = new BookingDataModel();
        booking.setArrival("TDPA");
        booking.setDeparture("EKM");

        BookingDataModel saved = bookingCrudRepo.save(booking);

        assertThat(saved.getBookingId()).isNotNull();
    }
}
