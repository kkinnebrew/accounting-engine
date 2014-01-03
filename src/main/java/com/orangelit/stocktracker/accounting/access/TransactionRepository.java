package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.Transaction;

import java.util.List;

public interface TransactionRepository {

    public List<Transaction> getTransactions(String accountId);

}

