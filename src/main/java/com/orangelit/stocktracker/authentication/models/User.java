package com.orangelit.stocktracker.authentication.models;

import java.util.UUID;

public class User {

    public String userId;
    public String firstName;
    public String lastName;
    public String email;
    public Boolean isActive;

    public User() {}

    public User(String firstName, String lastName, String email, Boolean isActive) {

        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;

    }

}
