
package com.example.data.user;

import com.example.domain.user.UserRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final PersonDataSource personDataSource;

    UserRepositoryImpl(PersonDataSource userDataSource) {
        this.personDataSource = userDataSource;
    }

    @Override
    public Optional<UserDataModel> findByUsername(String username) {
        return personDataSource.findByUsername(username);
    }

    @Override
    public void createUser(UserDataModel user) {
        personDataSource.save(user);
    }
}

interface PersonDataSource extends CrudRepository<UserDataModel, Integer> {
    @Query("SELECT * FROM person WHERE username = :username")
    Optional<UserDataModel> findByUsername(String username);
}
