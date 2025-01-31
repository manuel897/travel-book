package com.example.controller;

import com.example.domain.user.UserService;
import com.example.models.user.UserInputDto;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserController {
    private final UserService userService;

    UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onCreateUser(UserInputDto userInput) {
        userService.createUser(userInput);
    }
}
