package com.example.data.user;

import com.example.data.booking.BookingDataModel;
import com.example.domain.booking.BookingRepository;
import com.example.domain.booking.models.BookingStatus;
import com.example.domain.user.UserRepository;
import com.example.domain.user.UserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// To create demo users in dev environment
@Profile("dev")
@Component
public class DevUserSeeder implements CommandLineRunner {
    @Value("${SPRING_PROFILES_ACTIVE}")
    String env;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private static final Logger LOGGER = LogManager.getLogger();

    public DevUserSeeder(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Running DevUserSeeder ...");

        // Do not create demo users unless in dev environment
        if (!"dev".equals(env)) {
            throw new IllegalStateException("Dev seeder running outside dev!");
        }

        final String demoDriverUsername = "demo_driver";
        final String demoManagerUsername = "demo_manager";

        insertDummyUsers(demoDriverUsername, demoManagerUsername);
        insertDummyBooking(demoDriverUsername, demoManagerUsername);
    }

    private void insertDummyBooking(
            String demoDriverUsername,
            String demoManagerUsername
    ) {
        if (!bookingRepository.findAll().isEmpty()) {
            LOGGER.info("Not creating dummy bookings because bookings are not empty");
            return;
        }

        final BookingDataModel booking1 = new BookingDataModel();
        booking1.setDeparture("City A");
        booking1.setArrival("City B");
        booking1.setName("City A to B for few days");
        booking1.setNotes("Group of 4.");
        booking1.setStartTime(LocalDateTime.now());
        booking1.setFinishTime(LocalDateTime.now().plusDays(3));
        booking1.setPlannedDistance(100.5);
        booking1.setUnitOfMeasurement("km");
        booking1.setInitialQuote(BigDecimal.valueOf(7000));
        booking1.setOwnerUsername(demoManagerUsername);
        booking1.setFirstDriverUsername(demoDriverUsername);
        booking1.setBookingStatusId(BookingStatus.CONFIRMED.getCode());

        final BookingDataModel booking2 = new BookingDataModel();
        booking2.setDeparture("Town C");
        booking2.setArrival("Town D");
        booking2.setName("Town C to D for few days");
        booking2.setNotes("A booking from third party");
        booking2.setStartTime(LocalDateTime.now().plusDays(3));
        booking2.setFinishTime(LocalDateTime.now().plusDays(7));
        booking2.setPlannedDistance(442.5);
        booking2.setUnitOfMeasurement("km");
        booking2.setInitialQuote(BigDecimal.valueOf(12000));
        booking2.setOwnerUsername(demoManagerUsername);
        booking2.setFirstDriverUsername(demoDriverUsername);
        booking2.setBookingStatusId(BookingStatus.ENQUIRY.getCode());

        bookingRepository.createBooking(booking1);
        bookingRepository.createBooking(booking2);

        LOGGER.info("Created demo bookings in dev environment: {}, {}", booking1.getBookingId(), booking2.getBookingId());
    }

    private void insertDummyUsers(
            String demoDriverUsername,
            String demoManagerUsername
    ) {
        if(userRepository.findByUsername(demoDriverUsername).isPresent()) {
            return;
        }
        ;
        if(userRepository.findByUsername(demoManagerUsername).isPresent()) {
            return;
        }
        ;
        UserDataModel demoDriver = new UserDataModel(
                demoDriverUsername,
                "password",
                "bob",
                "driver",
                UserRole.DRIVER.getCode()
            );

        UserDataModel demoManager = new UserDataModel(
                demoManagerUsername,
                "password",
                "alice",
                "demo",
                UserRole.MANAGER.getCode()
            );

        userRepository.createUser(demoDriver);
        userRepository.createUser(demoManager);

        LOGGER.info("Created demo users in dev environment: {}, {}", demoManager.firstName, demoDriver.firstName);
    }
}
