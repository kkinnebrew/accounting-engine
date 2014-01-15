package com.orangelit.stocktracker.web.dtos;

import com.orangelit.stocktracker.accounting.models.AccountType;

import java.math.BigDecimal;

public class AccountTypeDTO {

    private String accountTypeId;
    private String accountTypeName;
    private BigDecimal balance;
    private String accountCategoryId;
    private String accountCategoryName;
    private String parentAccountTypeId;
    private String parentAccountTypeName;

    public AccountTypeDTO(AccountType accountType, BigDecimal balance) {
        this.accountTypeId = accountType.getAccountTypeId();
        this.accountTypeName = accountType.getName();
        this.balance = balance;
        this.accountCategoryId = accountType.getAccountCategory().getAccountCategoryId();
        this.accountCategoryName = accountType.getAccountCategory().getName();
        this.parentAccountTypeId = accountType.getParentAccountType() != null ? accountType.getParentAccountType().getAccountTypeId() : null;
        this.parentAccountTypeName = accountType.getParentAccountType() != null ? accountType.getParentAccountType().getName() : "-";
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountCategoryId() {
        return accountCategoryId;
    }

    public String getAccountCategoryName() {
        return accountCategoryName;
    }

    public String getParentAccountTypeId() {
        return parentAccountTypeId;
    }

    public String getParentAccountTypeName() {
        return parentAccountTypeName;
    }

}
