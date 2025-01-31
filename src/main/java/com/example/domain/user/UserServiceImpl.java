package com.example.domain.user;

import com.example.data.user.UserDataModel;

public class UserServiceImpl implements UserService {
    private CreateUser createUser;
    private UserRepository userRepository;

    @Override
    public UserDataModel findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void createUser(UserDataModel user) {
        createUser.call(user);
    }
}
