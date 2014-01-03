package com.orangelit.stocktracker.accounting.access;

import java.util.List;

public interface TransactionRepository {

    public List<String> getTransactions(String accountId);

}

