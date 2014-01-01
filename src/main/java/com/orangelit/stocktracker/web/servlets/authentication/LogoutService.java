package com.orangelit.stocktracker.web.servlets.authentication;

import com.google.inject.Inject;
import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;

public class LogoutService {

    // Private Fields

    private String token;

    @Inject
    private AuthenticationManager manager;

    // Endpoints

    @Get
    public Reply<String> expireToken(Request request) {
        manager.expireToken(token);
        return Reply.with("Invalid Credentials").status(200);
    }

    // Getters & Setters

    public void setToken(String token) {
        this.token = token;
    }

}
