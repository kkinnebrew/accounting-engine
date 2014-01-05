package com.orangelit.stocktracker.web.resources;

import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;
import com.orangelit.stocktracker.authentication.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/about")
public class AboutResource
{
    @GET
    @Path("/privacy")
    public View privacy(@Context HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }
        return new View("/about.jsp", request.getSession().getAttribute("user"));
    }
}