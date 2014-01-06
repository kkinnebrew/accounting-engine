package com.orangelit.stocktracker.accounting.models;

import java.util.Date;
import java.util.UUID;

public class AccountType {

    // Private Fields

    private String _accountTypeId;
    private String _name;
    private Boolean _direction;
    private AccountType _parentAccountType;
    private Date _created;

    // Constructors

    /**
     * @param accountTypeId
     * @param name
     */
    public AccountType(String accountTypeId, String name, Boolean direction, AccountType parentAccountType) {

        _accountTypeId = accountTypeId;
        _name = name;
        _direction = direction;
        _parentAccountType = parentAccountType;

    }

    /**
     * @param name
     */
    public AccountType(String name, Boolean direction, AccountType parentAccountType) {
        this(UUID.randomUUID().toString(), name, direction, parentAccountType);
    }

    // Getters & Setters

    public String getAccountTypeId() {
        return _accountTypeId;
    }

    public String getName() {
        return _name;
    }

    public Boolean getDirection() {
        return _direction;
    }

    public AccountType getParentAccountType() { return _parentAccountType; }

}
