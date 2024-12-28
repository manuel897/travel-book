package com.lordstdpa.domain.user;

import com.lordstdpa.data.user.UserDataModel;

public interface UserRepository
{
    UserDataModel findByUserId(String userId);
}
