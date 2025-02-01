
package com.example.data.user;

import com.example.domain.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final UserDataSource userDataSource;

    UserRepositoryImpl(UserDataSource userDataSource) {
        this.userDataSource = userDataSource;
    }

    @Override
    public Optional<UserDataModel> findByUsername(String username) {
        return userDataSource.findByUsername(username);
    }

    @Override
    public void createUser(UserDataModel user) {
        userDataSource.save(user);
    }
}

