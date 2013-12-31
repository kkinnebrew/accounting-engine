package com.orangelit.stocktracker.web.servlets;

import com.google.inject.Inject;
import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;


public class RegisterService {

    // Private Fields

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String passwordConfirm;

    @Inject
    private AuthenticationManager manager;

    // Endpoints

    @Get
    public Reply<String> registerUser() {

        try {
            manager.register(firstName, lastName, username, password, passwordConfirm);
            return Reply.with("")
                .as(Json.class)
                .type("application/json; charset=utf-8");
        } catch (InvalidInputException ex) {
            return Reply.with("Invalid request").status(400);
        }

    }

    // Getters & Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

}
