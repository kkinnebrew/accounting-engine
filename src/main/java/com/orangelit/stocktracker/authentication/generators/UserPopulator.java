package com.orangelit.stocktracker.authentication.generators;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.accounting.models.AccountCategory;
import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;

public class UserPopulator {

    private AuthenticationManager authenticationManager;
    private AccountingManager accountingManager;

    @Inject
    public UserPopulator(AuthenticationManager authenticationManager, AccountingManager accountingManager) throws Exception {
        this.authenticationManager = authenticationManager;
        this.accountingManager = accountingManager;
        try {
            loadData();
        } catch (Exception ignored) {}
    }

    @Transactional
    public void loadData() throws Exception {

        authenticationManager.register("Kevin", "Kinnebrew", "kevin.kinnebrew@gmail.com", "test", "test");

        AccountCategory assetCategory = accountingManager.createAccountCategory("Asset", true);
        AccountCategory liabilityCategory = accountingManager.createAccountCategory("Liability", false);
        AccountCategory incomeCategory = accountingManager.createAccountCategory("Income", false);
        AccountCategory expenseCategory = accountingManager.createAccountCategory("Expense", true);
        AccountCategory equityCategory = accountingManager.createAccountCategory("Equity", false);

        accountingManager.createAccountType("Assets", assetCategory.getAccountCategoryId(), null);
        accountingManager.createAccountType("Liabilities", liabilityCategory.getAccountCategoryId(), null);
        accountingManager.createAccountType("Income", incomeCategory.getAccountCategoryId(), null);
        accountingManager.createAccountType("Expenses", expenseCategory.getAccountCategoryId(), null);
        AccountType equityType = accountingManager.createAccountType("Equity", equityCategory.getAccountCategoryId(), null);

        accountingManager.createAccountType("Opening Balance", equityCategory.getAccountCategoryId(), equityType.getAccountTypeId());

    }

}
