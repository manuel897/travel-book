package com.example.data.user;

import com.example.domain.user.UserRepository;
import com.example.domain.user.UserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// To create demo users in dev environment
@Profile("dev")
@Component
public class DevUserSeeder implements CommandLineRunner {
    @Value("${SPRING_PROFILES_ACTIVE}")
    String env;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = LogManager.getLogger();

    public DevUserSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Running DevUserSeeder ...");

        // Do not create demo users unless in dev environment
        if (!"dev".equals(env)) {
            throw new IllegalStateException("Dev seeder running outside dev!");
        }



        UserDataModel demoDriver = new UserDataModel(
                "demo_driver",
                passwordEncoder.encode("password"),
                "bob",
                "driver",
                UserRole.DRIVER.getCode()
            );

        UserDataModel demoManager = new UserDataModel(
                "demo_manager",
                passwordEncoder.encode("password"),
                "alice",
                "demo",
                UserRole.MANAGER.getCode()
            );

        userRepository.createUser(demoDriver);
        userRepository.createUser(demoManager);

        LOGGER.info("Created demo users in dev environment: {}, {}", demoManager.firstName, demoDriver.firstName);
    }
}
