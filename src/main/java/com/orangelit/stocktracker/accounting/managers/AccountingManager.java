package com.orangelit.stocktracker.accounting.managers;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.Transaction;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;

import java.util.List;

public interface AccountingManager {

    public List<Transaction> getTransactions(Account account) throws InvalidInputException;

    public List<Transaction> getTransactions(String accountId) throws InvalidInputException;

    public void createTransaction(Transaction transaction) throws InvalidInputException;

    public void batchCreateTransactions(List<Transaction> transactions) throws InvalidInputException;

}
