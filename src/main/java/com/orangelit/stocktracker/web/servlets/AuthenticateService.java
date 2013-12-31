package com.orangelit.stocktracker.web.servlets;

import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;

import javax.inject.Inject;

public class AuthenticateService {

    // Private Fields

    private String token;

    @Inject
    private AuthenticationManager manager;

    // Endpoints

    @Get
    public Reply<String> validateToken() {

        if (manager.isValidToken(token)) {
            return Reply.with(token)
                .as(Json.class)
                .type("application/json; charset=utf-8");
        } else {
            return Reply.with("Invalid Token").status(401);
        }

    }

    // Getters & Setters

    public void setToken(String token) {
        this.token = token;
    }

}
