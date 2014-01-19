package com.orangelit.stocktracker.authentication.models;

import java.text.MessageFormat;
import java.util.UUID;

public class User {

    // Private Fields

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isActive;
    private String token;


    // Constructors

    public User() {}

    public User(String firstName, String lastName, String email, Boolean isActive) {

        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;

    }


    // Getters & Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getFullName() {
        return MessageFormat.format("{0} {1}", firstName, lastName);
    }

}
