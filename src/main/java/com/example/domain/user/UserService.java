package com.example.domain.user;

import com.example.data.user.UserDataModel;
import com.example.models.user.UserInputDto;

import java.util.Optional;

public interface UserService {
    Optional<UserDataModel> findUserByUsername(String username);

    void createUser(UserInputDto userInput);
}
