package com.example.domain.user;

import com.example.data.user.UserDataModel;

import java.util.Optional;

public interface UserRepository
{
    Optional<UserDataModel> findByUsername(String username);

    void createUser(UserDataModel user);
}
