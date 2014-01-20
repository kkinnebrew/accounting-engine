package com.orangelit.stocktracker.stocktracker.models.accounts;

import com.orangelit.stocktracker.stocktracker.models.Holding;

import java.math.BigDecimal;

/**
 * A class represented the outstanding long term gains for a portfolio.
 * Balance is computed for any gains on holdings held for a year or more.
 * @author kkinnebrew
 */
public class UnrealizedLongTermGainsAccount extends InvestmentAccount {

    @Override
    public BigDecimal getBalance() {

        BigDecimal balance = BigDecimal.ZERO;

        for (Holding holding : getHoldings()) {

            balance = balance.add(holding.getUnrealizedLongTermGain());

        }

        return balance;

    }

}
