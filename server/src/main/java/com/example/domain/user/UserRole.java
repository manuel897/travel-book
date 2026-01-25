package com.example.domain.user;

public enum UserRole {
    MANAGER(0),
    DRIVER(1),
    GUEST(3);

    private final int code;

    public int getCode() { return  code; }

    UserRole(int code) {
        this.code = code;
    }
}
