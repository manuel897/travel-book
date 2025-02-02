package com.example.domain.user;

public class Driver extends User {
    Driver(
            String firstName,
            String lastName,
            UserRole role) {
        super(firstName, lastName, UserRole.DRIVER);
    }
}

