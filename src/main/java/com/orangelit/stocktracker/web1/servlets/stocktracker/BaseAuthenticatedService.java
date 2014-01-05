package com.orangelit.stocktracker.web1.servlets.stocktracker;

import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;

import javax.inject.Inject;

public abstract class BaseAuthenticatedService {

    // Private Fields

    protected String token;

    @Inject
    protected AuthenticationManager manager;

    // Getters & Setters

    public void setToken(String token) {
        this.token = token;
    }

}
