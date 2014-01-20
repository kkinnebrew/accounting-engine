package com.orangelit.stocktracker.stocktracker.models.accounts;

import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.accounting.models.TransactionLine;
import com.orangelit.stocktracker.stocktracker.models.Holding;
import com.orangelit.stocktracker.stocktracker.models.Portfolio;

import java.math.BigDecimal;
import java.util.List;

public abstract class InvestmentAccount implements Account {

    public AccountType getAccountType() {
        return null;
    }

    /**
     * Computes the individual transaction lines referencing a
     * given account.
     * @return A List of TransactionLines
     */
    public List<TransactionLine> getTransactionLines() {
        return null;
    }

    public BigDecimal getBalance() {

        BigDecimal balance = BigDecimal.ZERO;

        for (TransactionLine line : getTransactionLines()) {

            balance = balance.add(line.getDebitAmount());
            balance = balance.subtract(line.getCreditAmount());

        }

        return balance;

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
