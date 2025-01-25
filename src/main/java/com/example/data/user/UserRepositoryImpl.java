package com.example.data.user;

import com.example.domain.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Override
    public UserDataModel findByUserId(String userId) {
        // TODO remove hardcode response
        if("mialu23".equals(userId)) {
            return new UserDataModel("mialu23", "Mia", "Lukas", "DRIVER");
        }
        return null;
    }
}
