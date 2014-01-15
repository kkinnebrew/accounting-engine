package com.orangelit.stocktracker.accounting.models;

import java.util.Date;
import java.util.UUID;

public class AccountType {

    // Private Fields

    private String _accountTypeId;
    private String _name;
    private AccountCategory _accountCategory;
    private AccountType _parentAccountType;
    private Date _created;

    // Constructors

    /**
     * @param accountTypeId
     * @param name
     */
    public AccountType(String accountTypeId, String name, AccountCategory accountCategory, AccountType parentAccountType) {

        _accountTypeId = accountTypeId;
        _name = name;
        _accountCategory = accountCategory;
        _parentAccountType = parentAccountType;

    }

    /**
     * @param name
     */
    public AccountType(String name, AccountCategory accountCategory, AccountType parentAccountType) {
        this(UUID.randomUUID().toString(), name, accountCategory, parentAccountType);
    }

    // Getters & Setters

    public String getAccountTypeId() {
        return _accountTypeId;
    }

    public String getName() {
        return _name;
    }

    public AccountCategory getAccountCategory() {
        return _accountCategory;
    }

    public AccountType getParentAccountType() { return _parentAccountType; }

}
