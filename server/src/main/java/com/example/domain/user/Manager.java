package com.example.domain.user;

public class Manager extends User {
    Manager(
            String firstName,
            String lastName,
            UserRole role) {
        super(firstName, lastName, UserRole.MANAGER);
    }
}
