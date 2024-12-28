package com.example.domain.user;

import com.example.data.user.UserDataModel;

public interface UserRepository
{
    UserDataModel findByUserId(String userId);
}
