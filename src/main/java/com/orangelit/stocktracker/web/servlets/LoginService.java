package com.orangelit.stocktracker.web.servlets;

import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Get;

import java.util.UUID;

public class LoginService {

    // Private Fields

    private String _username;
    private String _password;

    // Endpoints

    @Get
    public Reply<String> getToken(Request request) {

        return Reply.with(_username + " " + _password)
            .as(Json.class)
            .type("application/json; charset=utf-8");

    }

    // Getters & Setters

    public void setUsername(String username) {
        _username = username;
    }

    public void setPassword(String password) {
        _password = password;
    }

}
