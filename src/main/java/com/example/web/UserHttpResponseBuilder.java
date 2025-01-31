package com.example.web;

import com.example.domain.user.UserPresenter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserHttpResponseBuilder implements UserPresenter {
    private ResponseEntity<String> stringResponse;

    @Override
    public void presentUserCreated(String username) {
        final String message = "Account with username " + username + " was successfully created";
        stringResponse = createStringResponse(message, HttpStatusCode.valueOf(201));
    }

    @Override
    public void presentUserAlreadyExists(String username) {
        final String message = "Account with username " + username + " already exists";
        stringResponse = createStringResponse(message, HttpStatusCode.valueOf(400));
    }

    @Override
    public void presentUserCreationFailed(String username) {

    }

    private ResponseEntity<String> createStringResponse(String message, HttpStatusCode status) {
        return new ResponseEntity<>(message, status);
    }

    public ResponseEntity<String> getStringResponse() {
        return  stringResponse;
    }
}
