package com.example.domain.user;

public class User {
    String firstName;
    String lastName;
    UserRole role;

    public User(String firstName, String lastName, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public boolean isAllowedToCreateBooking() {
        return !UserRole.GUEST.equals(role);
    }

    public boolean isManager() {
        return UserRole.MANAGER.equals(role);
    }
}

