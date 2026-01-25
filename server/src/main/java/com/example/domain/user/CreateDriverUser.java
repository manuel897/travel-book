package com.example.domain.user;

import com.example.data.user.UserDataModel;
import com.example.models.user.UserInputDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateDriverUser {
    private final UserRepository userRepository;
    private final UserPresenter userPresenter;
    private final PasswordEncoder passwordEncoder;

    CreateDriverUser(UserRepository userRepository, UserPresenter userPresenter, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userPresenter = userPresenter;
        this.passwordEncoder = passwordEncoder;
    }

    void call(UserInputDto userInput) {
        final Optional<UserDataModel> existingUser = userRepository.findByUsername(userInput.getUsername());

        if(existingUser.isPresent()) {
            userPresenter.presentUserAlreadyExists(userInput.getUsername());
            return;
        }

        final UserDataModel user = new UserDataModel(
                userInput.getUsername(),
                passwordEncoder.encode(userInput.getPassword()),
                userInput.getFirstName(),
                userInput.getLastName(),
                UserRole.DRIVER.getCode()
        );

        userRepository.createUser(user);
        userPresenter.presentUserCreated(user.getUsername());
    }

}
