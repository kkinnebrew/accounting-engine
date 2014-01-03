package com.orangelit.stocktracker.accounting.models;

import com.orangelit.stocktracker.accounting.enumerations.AccountType;

import java.util.UUID;

/**
 * Represents an individual account in the accounting hierarchy. The hierarchy
 * is defined by account type, not be account, to allow for multiple users.
 * @author kkinnebrew
 */
public class Account {

    // Private Fields

    private String _accountId;
    private String _userId;
    private AccountType _accountType;
    private String _name;

    // Constructors

    /**
     * @param accountId
     * @param userId
     * @param accountType
     * @param name
     */
    public Account(String accountId, String userId, AccountType accountType, String name) {

        _accountId = accountId;
        _userId = userId;
        _accountType = accountType;
        _name = name;

    }

    /**
     * @param userId
     * @param accountType
     * @param name
     */
    public Account(String userId, AccountType accountType, String name) {
        this(UUID.randomUUID().toString(), userId, accountType, name);
    }

    // Getters & Setters

    public String getAccountId() {
        return _accountId;
    }

    public String getUserId() {
        return _userId;
    }

    public AccountType getAccountType() {
        return _accountType;
    }

    public String getName() {
        return _name;
    }

}
