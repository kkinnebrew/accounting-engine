package com.orangelit.stocktracker.web.resources;

import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

@Path("/accounting")
public class AccountingResource
{

    @GET
    @Path("/accounting")
    public View accounting(@Context HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }
        return new View("/accounting.jsp", request.getSession().getAttribute("user"));
    }

}