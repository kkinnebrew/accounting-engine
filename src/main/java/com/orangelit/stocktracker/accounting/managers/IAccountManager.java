package com.orangelit.stocktracker.accounting.managers;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.Transaction;

import java.util.List;

public interface IAccountManager {

    public List<Transaction> getTransactions(Account account);

    public List<Transaction> getTransactions(String accountId);

}
