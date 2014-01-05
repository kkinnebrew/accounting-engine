package com.orangelit.stocktracker.web.resources;

import com.googlecode.htmleasy.View;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/auth")
public class AuthenticationResource
{
    @GET
    @Path("/login")
    public View loginView() {
        return new View("/login.jsp");
    }

    @POST
    @Path("/login")
    public Response login(@Context HttpServletRequest request, @FormParam("username") String username, @FormParam("password") String password)
    {
        Response.ResponseBuilder response = Response.seeOther(URI.create("/about/privacy"));
        System.out.println("ip " + request.getRemoteAddr());
        request.getSession().setAttribute("user", username);
        return response.build();
    }

    @GET
    @Path("/logout")
    public String logout(@Context HttpServletRequest request)
    {
        String username = (String)request.getSession().getAttribute("user");
        return "Hello " + username;
    }
}
