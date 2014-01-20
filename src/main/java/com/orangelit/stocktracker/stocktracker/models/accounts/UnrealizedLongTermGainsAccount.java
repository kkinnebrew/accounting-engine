package com.orangelit.stocktracker.stocktracker.models.accounts;

import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.stocktracker.models.Holding;

import java.math.BigDecimal;

/**
 * A class represented the outstanding long term gains for a portfolio.
 * Balance is computed for any gains on holdings held for a year or more.
 * @author kkinnebrew
 */
public class UnrealizedLongTermGainsAccount extends InvestmentAccount {

    public UnrealizedLongTermGainsAccount(String accountId, String userId, AccountType accountType, String accountName) {
        super(accountId, userId, accountType, accountName);
    }

    public UnrealizedLongTermGainsAccount(String userId, AccountType accountType, String accountName) {
        super(userId, accountType, accountName);
    }

    @Override
    public BigDecimal getBalance() {

        BigDecimal balance = BigDecimal.ZERO;

        for (Holding holding : getHoldings()) {

            balance = balance.add(holding.getUnrealizedLongTermGain());

        }

        return balance;

    }

}
