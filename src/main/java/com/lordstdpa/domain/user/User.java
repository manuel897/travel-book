package com.lordstdpa.domain.user;

public class User {
    String firstName;
    String lastName;
    UserRole role;

    protected User(String firstName, String lastName, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}

