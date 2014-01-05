package com.orangelit.stocktracker.web1.servlets.authentication;

import com.google.inject.Inject;
import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.authentication.exceptions.UnauthorizedException;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;

import javax.servlet.http.HttpServletRequest;


public class LoginService {

    // Private Fields

    private String username;
    private String password;

    @Inject
    HttpServletRequest baseRequest;

    @Inject
    private AuthenticationManager manager;

    // Endpoints

    @Get
    public Reply<String> getToken(Request request) {

        try {
            String token = manager.getToken(username, password, baseRequest.getRemoteAddr());
            return Reply.with(token)
                .as(Json.class)
                .type("application/json; charset=utf-8");
        } catch (UnauthorizedException ex) {
            return Reply.with("Invalid Credentials").status(401);
        }

    }

    // Getters & Setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
