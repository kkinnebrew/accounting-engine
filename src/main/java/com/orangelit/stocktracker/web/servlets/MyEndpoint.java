package com.orangelit.stocktracker.web.servlets;

import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.web.dtos.TestModel;

public class MyEndpoint {

    @Get
    public Reply<TestModel> getData() {
        return Reply.with(new TestModel("Kevin", "Kinnebrew"))
            .as(Json.class)
            .type("application/json; charset=utf-8");
    }

}
