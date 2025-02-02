package com.example.models.user;

public class UserInputDto {
    String username;
    String password;
    String firstName;
    String lastName;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
