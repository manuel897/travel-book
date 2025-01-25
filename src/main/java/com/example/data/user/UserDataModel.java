package com.example.data.user;

public class UserDataModel {
    String userId;
    String firstName;
    String lastName;
    int userRoleId;

    public UserDataModel(String userId, String firstName, String lastName, int userRoleId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRoleId = userRoleId;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public String getUserId() {
        return userId;
    }
}
