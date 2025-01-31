package com.example.controller;

import com.example.data.user.UserDataModel;
import com.example.models.user.UserInputDto;

public interface UserController {
    void onCreateUser(UserInputDto userInput);
}
