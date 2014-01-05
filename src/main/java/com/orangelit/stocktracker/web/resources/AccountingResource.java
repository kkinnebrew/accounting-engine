package com.orangelit.stocktracker.web.resources;

import com.google.inject.Inject;
import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.web.views.AccountTypeAdminView;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Path("/accounting")
public class AccountingResource
{
    @Inject
    private AccountingManager accountingManager;

    @GET
    @Path("/accountTypes")
    public View accountTypes(@Context HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }

        AccountTypeAdminView model = new AccountTypeAdminView();

        model.accountTypes = new ArrayList<AccountType>();

        model.accountTypes.add(new AccountType("Asset", true));
        model.accountTypes.add(new AccountType("Liability", false));
        model.accountTypes.add(new AccountType("Income", false));
        model.accountTypes.add(new AccountType("Expense", true));
        model.accountTypes.add(new AccountType("Equity", true));

        model.user = (User)request.getSession().getAttribute("user");

        return new View("/accountTypes.jsp", model);
    }

    @PUT
    @Path("/accountTypes")
    public View accountTypes(@Context HttpServletRequest request, @FormParam("accountTypeId") String accountTypeId, @FormParam("accountTypeName") String accountTypeName)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }

        AccountTypeAdminView model = new AccountTypeAdminView();

        model.accountTypes = new ArrayList<AccountType>();
        model.user = (User)request.getSession().getAttribute("user");

        return new View("/accountTypes.jsp", model);
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

    @POST
    @Path("/createTransaction")
    public View createTransaction(@Context HttpServletRequest request,
                                  @FormParam("fromAccount") String fromAccount,
                                  @FormParam("toAccount") String toAccount,
                                  @FormParam("date") Date date,
                                  @FormParam("amount") BigDecimal amount,
                                  @FormParam("description") String description)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }
        return new View("/dashboard.jsp", request.getSession().getAttribute("user"));
    }
}