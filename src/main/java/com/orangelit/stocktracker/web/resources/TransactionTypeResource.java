package com.orangelit.stocktracker.web.resources;

import com.google.inject.Inject;
import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.web.views.TransactionTypeAdminView;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/transactionTypes")
public class TransactionTypeResource
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

        TransactionTypeAdminView model = new TransactionTypeAdminView();

        model.transactionTypes = accountingManager.getTransactionTypes();
        model.user = (User)request.getSession().getAttribute("user");

        return new View("/transactionTypes.jsp", model);

    }

    @POST
    @Path("/")
    public Response post(@Context HttpServletRequest request,
                         @FormParam("transactionTypeName") String transactionTypeName)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(transactionTypeName)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.createTransactionType(transactionTypeName);
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response put(@Context HttpServletRequest request,
                        @FormParam("transactionTypeId") String transactionTypeId,
                        @FormParam("transactionTypeName") String transactionTypeName)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(transactionTypeId) || StringUtils.isEmpty(transactionTypeName)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.updateTransactionType(transactionTypeId, transactionTypeName);
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @GET
    @Path("/delete")
    public Response delete(@Context HttpServletRequest request, @QueryParam("transactionTypeId") String transactionTypeId)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(transactionTypeId)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.removeTransactionType(transactionTypeId);
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }
}