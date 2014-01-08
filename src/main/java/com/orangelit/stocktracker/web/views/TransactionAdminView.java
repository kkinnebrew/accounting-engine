package com.orangelit.stocktracker.web.views;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.TransactionType;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.web.dtos.AccountTransactionDTO;

import java.util.List;

public class TransactionAdminView {
    public User user;
    public Account account;
    public List<AccountTransactionDTO> transactions;
    public List<TransactionType> transactionTypes;
    public List<Account> accounts;
    public String errorMessage;
}
