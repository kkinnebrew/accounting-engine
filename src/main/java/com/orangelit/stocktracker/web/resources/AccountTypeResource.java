package com.orangelit.stocktracker.web.resources;

import com.google.inject.Inject;
import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.web.views.AccountTypeAdminView;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Comparator;

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

        Collections.sort(model.accountTypes, new Comparator<AccountType>() {
            @Override
            public int compare(AccountType o1, AccountType o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Collections.sort(model.accountTypes, new Comparator<AccountType>() {
            @Override
            public int compare(AccountType o1, AccountType o2) {
                String o1Type = o1.getParentAccountType() != null ? o1.getParentAccountType().getName() : "";
                String o2Type = o1.getParentAccountType() != null ? o1.getParentAccountType().getName() : "";
                return o1Type.compareTo(o2Type);
            }
        });

        model.user = (User)request.getSession().getAttribute("user");

        return new View("/accountTypes.jsp", model);

    }

    @POST
    @Path("/")
    public Response post(@Context HttpServletRequest request,
                             @FormParam("accountTypeName") String accountTypeName,
                             @FormParam("direction") Boolean direction,
                             @FormParam("parentAccountTypeId") String parentAccountTypeId)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(accountTypeName) || direction == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.createAccountType(accountTypeName, direction, parentAccountTypeId);
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response put(@Context HttpServletRequest request,
                             @FormParam("accountTypeId") String accountTypeId,
                             @FormParam("accountTypeName") String accountTypeName,
                             @FormParam("direction") Boolean direction,
                             @FormParam("parentAccountTypeId") String parentAccountTypeId)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(accountTypeId) || StringUtils.isEmpty(accountTypeName) || direction == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.updateAccountType(accountTypeId, accountTypeName, direction, parentAccountTypeId);
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
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
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }
}