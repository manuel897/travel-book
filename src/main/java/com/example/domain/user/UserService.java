package com.example.domain.user;

import com.example.data.user.UserDataModel;

public interface UserService {
    UserDataModel findUserByUsername(String username);

    void createUser(UserDataModel user);
}
