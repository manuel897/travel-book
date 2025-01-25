package com.example.domain.user;

import com.example.domain.booking.User;

public class Driver extends User {
    Driver(
            String firstName,
            String lastName,
            UserRole role) {
        super(firstName, lastName, UserRole.DRIVER);
    }
}

