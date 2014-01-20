package com.orangelit.stocktracker.stocktracker.models.accounts;

import com.orangelit.stocktracker.stocktracker.models.Holding;

import java.math.BigDecimal;

/**
 * A class representing an asset account for a portfolio. Balances
 * are based on the current asset value of the underlying securities
 * held in that account.
 * @author kkinnebrew
 */
public class InvestmentAssetAccount extends InvestmentAccount {

    @Override
    public BigDecimal getBalance() {

        BigDecimal balance = BigDecimal.ZERO;

        for (Holding holding : getPortfolio().getHoldings()) {

            balance = balance.add(holding.getMarketValue());

        }

        return balance;

    }

}
