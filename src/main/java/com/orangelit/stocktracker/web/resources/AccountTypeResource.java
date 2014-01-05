package com.orangelit.stocktracker.web.resources;

import com.google.inject.Inject;
import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.web.views.AccountTypeAdminView;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/accountTypes")
public class AccountTypeResource
{
    @Inject
    private AccountingManager accountingManager;

    @GET
    @Path("/")
    public View get(@Context HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }

        AccountTypeAdminView model = new AccountTypeAdminView();

        model.accountTypes = accountingManager.getAccountTypes();
        model.user = (User)request.getSession().getAttribute("user");

        return new View("/accountTypes.jsp", model);

    }

    @POST
    @Path("/")
    public Response post(@Context HttpServletRequest request,
                             @FormParam("accountTypeName") String accountTypeName,
                             @FormParam("direction") Boolean direction)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(accountTypeName) || direction == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.createAccountType(accountTypeName, direction);
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response put(@Context HttpServletRequest request,
                             @FormParam("accountTypeId") String accountTypeId,
                             @FormParam("accountTypeName") String accountTypeName,
                             @FormParam("direction") Boolean direction)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(accountTypeId) || StringUtils.isEmpty(accountTypeName) || direction == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.updateAccountType(accountTypeId, accountTypeName, direction);
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @GET
    @Path("/delete")
    public Response delete(@Context HttpServletRequest request, @QueryParam("accountTypeId") String accountTypeId)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(accountTypeId)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.removeAccountType(accountTypeId);
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }
}