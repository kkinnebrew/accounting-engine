package com.orangelit.stocktracker.web.resources;

import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/dashboard")
public class DashboardResource
{
    @GET
    @Path("/")
    public View index(@Context HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }
        return new View("/dashboard.jsp", request.getSession().getAttribute("user"));
    }

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