package com.orangelit.stocktracker.web.dtos;

import com.orangelit.stocktracker.accounting.models.Account;

import java.math.BigDecimal;

public class AccountDTO {

    private String accountId;
    private String accountName;
    private BigDecimal balance;
    private String accountCategoryId;
    private String accountCategoryName;
    private String accountTypeId;
    private String accountTypeName;
    private String userId;

    public AccountDTO(Account account, BigDecimal balance) {
        this.accountId = account.getAccountId();
        this.accountName = account.getAccountName();
        this.balance = balance;
        this.accountCategoryId = account.getAccountType().getAccountCategory().getAccountCategoryId();
        this.accountCategoryName = account.getAccountType().getAccountCategory().getName();
        this.accountTypeId = account.getAccountType().getAccountTypeId();
        this.accountTypeName = account.getAccountType().getName();
        this.userId = account.getUserId();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountCategoryName() {
        return accountCategoryName;
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public String getUserId() {
        return userId;
    }

}
