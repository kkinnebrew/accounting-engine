package com.orangelit.stocktracker.web.servlets.stocktracker;

import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Get;

public class GetPortfoliosService extends BaseAuthenticatedService {

    // Endpoints

    @Get
    public Reply<String> validateToken() {

        if (manager.isValidToken(token)) {
            return Reply.with("Invalid Token").status(401);
        }

        return Reply.with("");

    }

}
