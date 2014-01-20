package com.orangelit.stocktracker.web.resources;

import com.google.inject.Inject;
import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.stocktracker.managers.InvestmentManager;
import com.orangelit.stocktracker.stocktracker.models.Portfolio;
import com.orangelit.stocktracker.web.views.PortfoliosView;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Path("/portfolios")
public class PortfolioResource
{
    @Inject
    private InvestmentManager investmentManager;

    @GET
    @Path("/")
    public View get(@Context HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }

        PortfoliosView model = new PortfoliosView();
        model.user = (User)request.getSession().getAttribute("user");
        List<Portfolio> portfolios = investmentManager.getPortfolios(model.user.getUserId());

        model.portfolios = !portfolios.isEmpty() ? portfolios : new ArrayList<Portfolio>();

        Collections.sort(model.portfolios, new Comparator<Portfolio>() {
            @Override
            public int compare(Portfolio o1, Portfolio o2) {
                return o1.getPortfolioName().compareTo(o2.getPortfolioName());
            }
        });

        return new View("/portfolios.jsp", model);

    }

    @POST
    @Path("/")
    public Response post(@Context HttpServletRequest request,
                         @FormParam("portfolioName") String portfolioName)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        User user = (User)request.getSession().getAttribute("user");

        if (StringUtils.isEmpty(portfolioName)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            investmentManager.createPortfolio(portfolioName, user.getUserId());
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response put(@Context HttpServletRequest request,
                        @FormParam("portfolioId") String portfolioId,
                        @FormParam("portfolioName") String portfolioName)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        User user = (User)request.getSession().getAttribute("user");

        if (StringUtils.isEmpty(portfolioId) || StringUtils.isEmpty(portfolioName)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            investmentManager.updatePortfolio(portfolioId, portfolioName, user.getUserId());
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @GET
    @Path("/delete")
    public Response delete(@Context HttpServletRequest request, @QueryParam("portfolioId") String portfolioId)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(portfolioId)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            investmentManager.removePortfolio(portfolioId);
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }
}