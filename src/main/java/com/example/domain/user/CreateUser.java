package com.example.domain.user;

import com.example.data.user.UserDataModel;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserRepository userRepository;
    private UserPresenter userPresenter;

    void call(UserDataModel user) {
        final UserDataModel existingUser = userRepository.findByUsername(user.getUserId());

        if(existingUser != null) {
            userPresenter.presentUserAlreadyExists(user.getUserId());
        }

        userRepository.createUser(user);
        userPresenter.presentUserCreated(user.getUserId());
    }

}
