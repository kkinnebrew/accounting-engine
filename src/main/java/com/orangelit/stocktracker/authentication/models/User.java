package com.orangelit.stocktracker.authentication.models;

import java.text.MessageFormat;
import java.util.UUID;

public class User {

    public String userId;
    public String firstName;
    public String lastName;
    public String email;
    public Boolean isActive;
    private String token;

    public User() {}

    public User(String firstName, String lastName, String email, Boolean isActive) {

        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;

    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return MessageFormat.format("{0} {1}", firstName, lastName);
    }

}
