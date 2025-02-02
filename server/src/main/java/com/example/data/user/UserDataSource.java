package com.example.data.user;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDataSource extends CrudRepository<UserDataModel, Integer> {
    @Query("SELECT * FROM person WHERE username = :username")
    Optional<UserDataModel> findByUsername(String username);
}