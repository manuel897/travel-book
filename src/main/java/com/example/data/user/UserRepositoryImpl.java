
package com.example.data.user;

import com.example.domain.user.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {
    private static final Logger LOGGER = LogManager.getLogger();

    private final UserDataSource userDataSource;

    UserRepositoryImpl(UserDataSource userDataSource) {
        this.userDataSource = userDataSource;
    }

    @Override
    public Optional<UserDataModel> findByUsername(String username) {
        LOGGER.trace("Find user with username `{}`", username);

        return userDataSource.findByUsername(username);
    }

    @Override
    public void createUser(UserDataModel user) {
        LOGGER.info("Creating user with username `{}`", user.username);

        userDataSource.save(user);
    }
}

