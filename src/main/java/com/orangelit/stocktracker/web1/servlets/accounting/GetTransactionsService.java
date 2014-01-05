package com.orangelit.stocktracker.web1.servlets.accounting;

import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.accounting.models.Transaction;

import java.util.List;

public class GetTransactionsService {

    @Get
    public Reply<List<Transaction>> getTransactions() {
        return null;
    }

}
