package com.orangelit.stocktracker.accounting.engine;

import com.google.inject.Inject;
import com.orangelit.stocktracker.accounting.access.*;
import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.AccountType;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class AccountingEngine {

    private AccountTree assetTree;
    private AccountTree liabilityTree;
    private AccountTree incomeTree;
    private AccountTree expenseTree;
    private AccountTree equityTree;

    @Inject
    private AccountRepository accountRepository;

    @Inject
    private AccountTypeRepository accountTypeRepository;

    public AccountingEngine() {

    }

    public void generate(String userId) {

        List<AccountType> assetAccountTypes = new LinkedList<>();
        List<AccountType> liabilityAccountTypes = new LinkedList<>();
        List<AccountType> incomeAccountTypes = new LinkedList<>();
        List<AccountType> expenseAccountTypes = new LinkedList<>();
        List<AccountType> equityAccountTypes = new LinkedList<>();

        for (AccountType type : accountTypeRepository.getAll()) {
            switch (type.getAccountCategory().getName()) {
                case "Asset": assetAccountTypes.add(type); break;
                case "Liability": liabilityAccountTypes.add(type); break;
                case "Income": incomeAccountTypes.add(type); break;
                case "Expense": expenseAccountTypes.add(type); break;
                case "Equity": equityAccountTypes.add(type); break;
            }
        }

        List<Account> accounts = accountRepository.getAccountsForUser(userId);

        assetTree = new AccountTree(assetAccountTypes, accounts);
        liabilityTree = new AccountTree(liabilityAccountTypes, accounts);
        incomeTree = new AccountTree(incomeAccountTypes, accounts);
        expenseTree = new AccountTree(expenseAccountTypes, accounts);
        equityTree = new AccountTree(equityAccountTypes, accounts);

    }

    public BigDecimal getAssetBalance() {
        return assetTree.getBalance();
    }

    public BigDecimal getLiabilityBalance() {
        return liabilityTree.getBalance();
    }

    public BigDecimal getIncomeBalance() {
        return incomeTree.getBalance();
    }

    public BigDecimal getExpenseBalance() {
        return expenseTree.getBalance();
    }

    public BigDecimal getEquityBalance() {
        return equityTree.getBalance();
    }

}
