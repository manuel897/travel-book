package com.example.data.user;

import com.example.domain.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Override
    public UserDataModel findByUsername(String username) {
        // TODO remove hardcode response
        if("mialu23".equals(username)) {
            return new UserDataModel("mialu23", "Mia", "Lukas", 0);
        }
        return null;
    }
}
