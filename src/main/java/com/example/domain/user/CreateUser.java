package com.example.domain.user;

import com.example.data.user.UserDataModel;
import com.example.models.user.UserInputDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateUser {
    private final UserRepository userRepository;
    private final UserPresenter userPresenter;

    CreateUser(UserRepository userRepository, UserPresenter userPresenter) {
        this.userRepository = userRepository;
        this.userPresenter = userPresenter;
    }

    void call(UserInputDto userInput) {
        final Optional<UserDataModel> existingUser = userRepository.findByUsername(userInput.getUsername());

        if(existingUser.isPresent()) {
            userPresenter.presentUserAlreadyExists(userInput.getUsername());
            return;
        }

        final UserDataModel user = new UserDataModel(
                userInput.getUsername(),
                userInput.getPassword(), // TODO save hash
                userInput.getFirstName(),
                userInput.getLastName(),
                0 // TODO decide logic for driver
        );

        userRepository.createUser(user);
        userPresenter.presentUserCreated(user.getUsername());
    }

}
