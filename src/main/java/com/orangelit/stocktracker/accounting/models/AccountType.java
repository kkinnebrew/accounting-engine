package com.orangelit.stocktracker.accounting.models;

import java.util.UUID;

/**
 * A model representing an account type. Account types are hierarchical and
 * define the ability to sum items in the account hierarchy.
 * @author kkinnebrew
 */
public class AccountType {

    // Private Fields

    private String _accountTypeId;
    private String _parentAccountTypeId;
    private String _name;

    // Constructors

    /**
     * @param accountTypeId
     * @param parentAccountTypeId
     * @param name
     */
    public AccountType(String accountTypeId, String parentAccountTypeId, String name) {

        _accountTypeId = accountTypeId;
        _parentAccountTypeId = parentAccountTypeId;
        _name = name;

    }

    /**
     * @param parentAccountTypeId
     * @param name
     */
    public AccountType(String parentAccountTypeId, String name) {
        this(UUID.randomUUID().toString(), parentAccountTypeId, name);
    }

    // Getters & Setters

    public String getAccountTypeId() {
        return _accountTypeId;
    }

    public String getParentAccountType() {
        return _parentAccountTypeId;
    }

    public String getName() {
        return _name;
    }
}
