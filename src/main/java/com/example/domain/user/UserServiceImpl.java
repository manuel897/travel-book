package com.example.domain.user;

import com.example.data.user.UserDataModel;
import com.example.models.user.UserInputDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    private CreateUser createUser;
    private UserRepository userRepository;

    UserServiceImpl(CreateUser createUser, UserRepository userRepository) {
        this.createUser = createUser;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDataModel> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void createUser(UserInputDto userInput) {
        createUser.call(userInput);
    }
}
