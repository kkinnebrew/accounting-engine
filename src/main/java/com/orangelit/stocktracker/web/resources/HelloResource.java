package com.orangelit.stocktracker.web.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class HelloResource
{
    @GET
    @Path("{name}")
    public String hello(@PathParam("name") final String name)
    {
        return "Hello " + name;
    }
}