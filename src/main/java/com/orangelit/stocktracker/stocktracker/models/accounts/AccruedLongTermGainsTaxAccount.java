package com.orangelit.stocktracker.stocktracker.models.accounts;

import com.orangelit.stocktracker.accounting.models.AccountType;

import java.math.BigDecimal;

/**
 * A class representing an account containing all estimated tax payments
 * for unrealized long term security holdings.
 * @author kkinnebrew
 */
public class AccruedLongTermGainsTaxAccount extends InvestmentAccount {

    public AccruedLongTermGainsTaxAccount(String accountId, String userId, AccountType accountType, String accountName) {
        super(accountId, userId, accountType, accountName);
    }

    public AccruedLongTermGainsTaxAccount(String userId, AccountType accountType, String accountName) {
        super(userId, accountType, accountName);
    }

    @Override
    public BigDecimal getBalance() {

        UnrealizedLongTermGainsAccount account = getUnrealizedLongTermGainsAccount();

        BigDecimal taxRate = new BigDecimal(0.15);

        BigDecimal balance = account.getBalance().multiply(taxRate);

        return balance;

    }

}
