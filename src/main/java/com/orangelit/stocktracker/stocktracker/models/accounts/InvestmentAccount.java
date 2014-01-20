package com.orangelit.stocktracker.stocktracker.models.accounts;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.stocktracker.models.Holding;
import com.orangelit.stocktracker.stocktracker.models.Portfolio;

import java.util.List;

public abstract class InvestmentAccount extends Account {

    public InvestmentAccount(String accountId, String userId, AccountType accountType, String accountName) {
        super(accountId, userId, accountType, accountName);
    }

    public InvestmentAccount(String userId, AccountType accountType, String accountName) {
        super(userId, accountType, accountName);
    }

    public Portfolio getPortfolio() {
        return null;
    }

    public List<Holding> getHoldings() {
        return null;
    }

    public UnrealizedLongTermGainsAccount getUnrealizedLongTermGainsAccount() {
        return getPortfolio().getUnrealizedLongTermGainsAccount();
    }

    public UnrealizedShortTermGainsAccount getUnrealizedShortTermGainsAccount() {
        return getPortfolio().getUnrealizedShortTermGainsAccount();
    }

}
