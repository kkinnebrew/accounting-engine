package com.orangelit.stocktracker.stocktracker.models.accounts;

import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.stocktracker.models.Holding;

import java.math.BigDecimal;

/**
 * A class representing an asset account for a portfolio. Balances
 * are based on the current asset value of the underlying securities
 * held in that account.
 * @author kkinnebrew
 */
public class InvestmentAssetAccount extends InvestmentAccount {

    public InvestmentAssetAccount(String accountId, String userId, AccountType accountType, String accountName) {
        super(accountId, userId, accountType, accountName);
    }

    public InvestmentAssetAccount(String userId, AccountType accountType, String accountName) {
        super(userId, accountType, accountName);
    }

    @Override
    public BigDecimal getBalance() {

        BigDecimal balance = BigDecimal.ZERO;

        for (Holding holding : getPortfolio().getHoldings()) {

            balance = balance.add(holding.getMarketValue());

        }

        return balance;

    }

}
