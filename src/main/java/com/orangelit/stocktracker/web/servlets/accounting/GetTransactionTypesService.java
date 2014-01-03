package com.orangelit.stocktracker.web.servlets.accounting;

import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.accounting.enumerations.TransactionType;

import java.util.List;

public class GetTransactionTypesService {

    @Get
    public Reply<List<TransactionType>> getTransactionTypes() {
        return null;
    }

}
