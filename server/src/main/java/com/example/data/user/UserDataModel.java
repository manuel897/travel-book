package com.example.data.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("person")
public class UserDataModel {
    @Id
    @Column("id")
    Integer id;

    @Column("username")
    String username;

    @Column("password")
    String hash;

    @Column("first_name")
    String firstName;

    @Column("last_name")
    String lastName;

    @Column("person_role_id")
    int userRoleId;

    public UserDataModel(String username, String hash, String firstName, String lastName, int userRoleId) {
        this.username = username;
        this.hash = hash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRoleId = userRoleId;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public String getUsername() {
        return username;
    }
}
