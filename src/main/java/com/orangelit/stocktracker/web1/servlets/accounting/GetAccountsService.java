package com.orangelit.stocktracker.web1.servlets.accounting;

import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Get;
import com.orangelit.stocktracker.accounting.models.Account;

import java.util.List;

public class GetAccountsService {

    @Get
    public Reply<List<Account>> getAccounts() {
        return null;
    }

}
