package com.orangelit.stocktracker.web.dtos;

import com.orangelit.stocktracker.accounting.models.AccountType;

import java.math.BigDecimal;

public class AccountTypeDTO {

    private String accountTypeId;
    private String accountTypeName;
    private BigDecimal balance;
    private Boolean direction;
    private String parentAccountTypeId;
    private String parentAccountTypeName;

    public AccountTypeDTO(AccountType accountType, BigDecimal balance) {
        this.accountTypeId = accountType.getAccountTypeId();
        this.accountTypeName = accountType.getName();
        this.balance = balance;
        this.direction = accountType.getDirection();
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

    public Boolean getDirection() {
        return direction;
    }

    public String getParentAccountTypeId() {
        return parentAccountTypeId;
    }

    public String getParentAccountTypeName() {
        return parentAccountTypeName;
    }

}
