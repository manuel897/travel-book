package com.example.domain.user;

public interface UserPresenter {
    void presentUserCreated(String username);

    void presentUserAlreadyExists(String username);

    void presentUserCreationFailed(String username);
}
