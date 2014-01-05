package com.orangelit.stocktracker.web.resources;

import com.google.inject.Inject;
import com.googlecode.htmleasy.View;
import com.orangelit.stocktracker.authentication.exceptions.UnauthorizedException;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;
import com.orangelit.stocktracker.authentication.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/auth")
public class AuthenticationResource
{
    @Inject
    private AuthenticationManager authenticationManager;

    @GET
    @Path("/login")
    public View login() {
        return new View("/login.jsp");
    }

    @POST
    @Path("/login")
    public Response login(@Context HttpServletRequest request, @FormParam("username") String username, @FormParam("password") String password)
    {
        try {
            User user = authenticationManager.getToken(username, password, request.getRemoteAddr());
            request.getSession().setAttribute("user", user);
        } catch(UnauthorizedException ex) {
            return Response.status(401).build();
        }
        return Response.seeOther(URI.create("/dashboard")).build();
    }

    @GET
    @Path("/logout")
    public Response logout(@Context HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            request.getSession().removeAttribute("user");
        }
        return Response.seeOther(URI.create("/auth/login")).build();
    }

    @GET
    @Path("/register")
    public View register() {
        return new View("/register.jsp");
    }
}
