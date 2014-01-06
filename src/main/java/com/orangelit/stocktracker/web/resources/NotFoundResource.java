package com.orangelit.stocktracker.web.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/notfound")
public class NotFoundResource
{
    @GET
    @Path("/")
    public Response index()
    {
        return Response.status(404).build();
    }

}