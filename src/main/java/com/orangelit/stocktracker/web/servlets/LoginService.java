package com.orangelit.stocktracker.web.servlets;

import com.google.inject.Inject;
import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.authentication.access.SessionRepository;

import java.util.UUID;

public class LoginService {

    // Private Fields

    private String _username;
    private String _password;

    private SessionRepository _sessionRepository;

    // Constructors

    @Inject
    public LoginService(SessionRepository sessionRepository) {
        _sessionRepository = sessionRepository;
    }

    // Endpoints

    @Get
    public Reply<String> getToken(Request request) {

        String token = _sessionRepository.generateSession();

        return Reply.with(token)
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
