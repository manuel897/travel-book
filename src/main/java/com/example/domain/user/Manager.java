package com.example.domain.user;

import com.example.domain.booking.User;

public class Manager extends User {
    Manager(
            String firstName,
            String lastName,
            UserRole role) {
        super(firstName, lastName, UserRole.MANAGER);
    }
}
