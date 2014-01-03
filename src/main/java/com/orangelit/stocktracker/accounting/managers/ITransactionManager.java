package com.orangelit.stocktracker.accounting.managers;

import com.orangelit.stocktracker.accounting.models.Transaction;

import java.util.List;

public interface ITransactionManager {

    public void createTransaction(Transaction transaction);

    public void batchCreateTransactions(List<Transaction> transactions);

}
