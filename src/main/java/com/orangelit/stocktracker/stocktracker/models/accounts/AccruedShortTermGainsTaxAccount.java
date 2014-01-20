package com.orangelit.stocktracker.stocktracker.models.accounts;

import java.math.BigDecimal;

/**
 * A class representing an account containing all estimated tax payments
 * for unrealized short term security holdings.
 * @author kkinnebrew
 */
public class AccruedShortTermGainsTaxAccount extends InvestmentAccount {

    @Override
    public BigDecimal getBalance() {

        UnrealizedShortTermGainsAccount account = getUnrealizedShortTermGainsAccount();

        BigDecimal taxRate = new BigDecimal(0.25);

        BigDecimal balance = account.getBalance().multiply(taxRate);

        return balance;

    }

}
