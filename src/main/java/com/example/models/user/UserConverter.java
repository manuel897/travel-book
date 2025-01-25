package com.example.models.user;

import com.example.data.user.UserDataModel;
import com.example.domain.booking.User;
import com.example.domain.user.UserRole;
import com.example.models.EntityConverter;

public class UserConverter implements EntityConverter<User, UserDataModel> {

    @Override
    public User toEntity(UserDataModel d) {
        return new User(
            d.getFirstName(),
            d.getLastName(), 
            getUserRole(d.getUserRoleId())
        );
    }
    
    int getUserRoleId(UserRole userRole) {
        return switch (userRole) {
            case DRIVER -> 0;
            case MANAGER -> 1;
            case GUEST -> 2;
        };
    }

    UserRole getUserRole(int userRoleId) {
        return switch (userRoleId) {
            case 0 -> UserRole.MANAGER;
            case 1 -> UserRole.DRIVER;
            case 2 -> UserRole.GUEST;
            default -> throw new IllegalStateException("Unexpected value: " + userRoleId);
        };
    }
}


