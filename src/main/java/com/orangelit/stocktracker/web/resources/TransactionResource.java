package com.orangelit.stocktracker.web.resources;

import com.google.inject.Inject;
import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.Transaction;
import com.orangelit.stocktracker.accounting.models.TransactionLine;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;
import com.orangelit.stocktracker.common.exceptions.ItemNotFoundException;
import com.orangelit.stocktracker.web.dtos.AccountTransactionDTO;
import com.orangelit.stocktracker.web.views.TransactionAdminView;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.*;

@Path("/transactions")
public class TransactionResource {

    @Inject
    private AccountingManager accountingManager;

    @GET
    @Path("/")
    public View get(@Context HttpServletRequest request, @QueryParam("accountId") String accountId) throws ItemNotFoundException, InvalidInputException
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }

        TransactionAdminView model = new TransactionAdminView();
        model.accounts = accountingManager.getAccounts();

        if (StringUtils.isEmpty(accountId) && model.accounts.size() > 0) {
            throw new RedirectException("/transactions?accountId=" + model.accounts.get(0).getAccountId());
        }

        Account account = accountingManager.getAccount(accountId);

        model.account = account;
        model.transactionTypes = accountingManager.getTransactionTypes();
        model.user = (User)request.getSession().getAttribute("user");
        model.transactions = new LinkedList<AccountTransactionDTO>();

        List<Transaction> transactions = accountingManager.getTransactions(accountId);

        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.getTransactionDate().compareTo(o2.getTransactionDate());
            }
        });

        BigDecimal balance = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            List<Account> accounts = new LinkedList<Account>();
            for (TransactionLine line : transaction.getTransactionLines()) {
                if (!line.getAccount().getAccountId().equals(accountId)) {
                    accounts.add(line.getAccount());
                    continue;
                }
                BigDecimal amount = BigDecimal.ZERO;
                if (account.getAccountType().getDirection()) {
                    amount = amount.add(line.getDebitAmount());
                    amount = amount.subtract(line.getCreditAmount());
                } else {
                    amount = amount.subtract(line.getDebitAmount());
                    amount = amount.add(line.getCreditAmount());
                }
                balance = balance.add(amount);
                model.transactions.add(new AccountTransactionDTO(
                        transaction.getTransactionId(),
                        transaction.getTransactionDate(),
                        transaction.getTransactionType(),
                        line.getAccount(),
                        amount,
                        balance)
                );
            }
        }

        Collections.reverse(model.transactions);

        return new View("/transactions.jsp", model);

    }

    @POST
    @Path("/transfer")
    public Response post(@Context HttpServletRequest request,
                         @FormParam("fromAccountId") String fromAccountId,
                         @FormParam("toAccountId") String toAccountId,
                         @FormParam("transactionTypeId") String transactionTypeId,
                         @FormParam("transactionDate") Date transactionDate,
                         @FormParam("amount") BigDecimal amount,
                         @FormParam("description") String description)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(fromAccountId) || StringUtils.isEmpty(toAccountId) || StringUtils.isEmpty(transactionTypeId) || StringUtils.isEmpty(description) || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.createTransfer(fromAccountId, toAccountId, transactionTypeId, transactionDate, amount, description);
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

    @GET
    @Path("/delete")
    public Response delete(@Context HttpServletRequest request, @QueryParam("transactionId") String transactionId)
    {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/auth/login");
        }

        if (StringUtils.isEmpty(transactionId)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            accountingManager.removeTransaction(transactionId);
        } catch (Exception ex) {
            return Response.ok(ex.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

}
