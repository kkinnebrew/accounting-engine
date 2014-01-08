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

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Path("/transactions")
public class TransactionResource {

    @Inject
    private AccountingManager accountingManager;

    @GET
    @Path("/{accountId}")
    public View get(@Context HttpServletRequest request, @PathParam("accountId") String accountId) throws ItemNotFoundException, InvalidInputException
    {
        if (request.getSession().getAttribute("user") == null)
        {
            throw new RedirectException("/auth/login");
        }

        TransactionAdminView model = new TransactionAdminView();
        Account account = accountingManager.getAccount(accountId);

        model.account = account;
        model.accounts = accountingManager.getAccounts();
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
            for (TransactionLine line : transaction.getTransactionLines()) {
                if (!line.getAccount().getAccountId().equals(accountId)) {
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

        Collections.sort(model.transactions, new Comparator<AccountTransactionDTO>() {
            @Override
            public int compare(AccountTransactionDTO o1, AccountTransactionDTO o2) {
                return o2.getTransactionDate().compareTo(o1.getTransactionDate());
            }
        });

        return new View("/transactions.jsp", model);

    }

}
