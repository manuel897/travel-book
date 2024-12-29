package com.example.data.user;

public class UserDataModel {
    String userId;
    String firstName;
    String lastName;
    String userRole;

    public UserDataModel(String userId, String firstName, String lastName, String userRole) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }
}
