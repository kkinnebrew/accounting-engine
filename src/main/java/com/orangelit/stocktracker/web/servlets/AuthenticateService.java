package com.orangelit.stocktracker.web.servlets;

import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.web.dtos.TestModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Date;

public class AuthenticateService {

    // Private Fields

    private String _token;

    @Inject
    private EntityManager em;

    // Endpoints

    @Get
    public Reply<String> validateToken(Request request) {

        TestModel model = new TestModel(12, "hello", new Date());

        em.getTransaction().begin();
        em.persist(model);
        em.getTransaction().commit();

        return Reply.with(_token)
            .as(Json.class)
            .type("application/json; charset=utf-8");
    }

    // Getters & Setters

    public void setToken(String token) {
        _token = token;
    }

}
