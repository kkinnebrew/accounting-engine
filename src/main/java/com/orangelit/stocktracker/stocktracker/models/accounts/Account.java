package com.orangelit.stocktracker.stocktracker.models.accounts;

import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.accounting.models.TransactionLine;

import java.math.BigDecimal;
import java.util.List;

public interface Account {

    public AccountType getAccountType();

    /**
     * Computes the individual transaction lines referencing a
     * given account.
     * @return A List of TransactionLines
     */
    public List<TransactionLine> getTransactionLines();

    public abstract BigDecimal getBalance();

}
