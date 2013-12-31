package com.orangelit.stocktracker.web.servlets;

import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Get;

public class AuthenticateService {

    // Private Fields

    private String _token;

    // Endpoints

    @Get
    public Reply<String> validateToken(Request request) {
        return Reply.with(_token)
            .as(Json.class)
            .type("application/json; charset=utf-8");
    }

    // Getters & Setters

    public void setToken(String token) {
        _token = token;
    }

}
