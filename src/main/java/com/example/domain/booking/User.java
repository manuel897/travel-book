package com.example.domain.booking;

import com.example.domain.user.UserRole;

public class User {
    String firstName;
    String lastName;
    UserRole role;

    public User(String firstName, String lastName, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    boolean isAllowedToCreateBooking() {
        return !UserRole.GUEST.equals(role);
    }

    boolean isManager() {
        return UserRole.MANAGER.equals(role);
    }
}

