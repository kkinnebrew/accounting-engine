package com.orangelit.stocktracker.web.resources;

import com.google.inject.Inject;
import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.web.views.AccountAdminView;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/accounts")
public class AccountResource
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

        AccountAdminView model = new AccountAdminView();

        model.accountTypes = accountingManager.getAccountTypes();
        model.accounts = accountingManager.getAccounts();
        model.user = (User)request.getSession().getAttribute("user");

        return new View("/accounts.jsp", model);

    }

    @POST
    @Path("/")
    public Response post(@Context HttpServletRequest request,
                         @FormParam("accountName") String accountName,
                         @FormParam("accountTypeId") String accountTypeId)
    {
        User user = (User)request.getSession().getAttribute("user");

        if (user == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(accountName) || StringUtils.isEmpty(accountTypeId)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.createAccount(accountName, accountTypeId, user.getUserId());
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response put(@Context HttpServletRequest request,
                        @FormParam("accountId") String accountId,
                        @FormParam("accountName") String accountName,
                        @FormParam("accountTypeId") String accountTypeId)
    {
        User user = (User)request.getSession().getAttribute("user");

        if (user == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(accountId) || StringUtils.isEmpty(accountName) || StringUtils.isEmpty(accountTypeId)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.updateAccount(accountId, accountName, accountTypeId, user.getUserId());
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @GET
    @Path("/delete")
    public Response delete(@Context HttpServletRequest request, @QueryParam("accountId") String accountId)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(accountId)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.removeAccount(accountId);
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }
}