package com.orangelit.stocktracker.web.resources;

import com.googlecode.htmleasy.View;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/about")
public class About
{
    @GET @Path("/privacy")
    public View privacy(@Context HttpServletRequest request)
    {
        return new View("/about.jsp", request.getSession().getAttribute("user"));
    }
}