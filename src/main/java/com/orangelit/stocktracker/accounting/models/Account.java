package com.orangelit.stocktracker.accounting.models;

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
    private String _accountName;

    // Constructors

    /**
     * @param accountId
     * @param userId
     * @param accountType
     * @param accountName
     */
    public Account(String accountId, String userId, AccountType accountType, String accountName) {

        _accountId = accountId;
        _userId = userId;
        _accountType = accountType;
        _accountName = accountName;

    }

    /**
     * @param userId
     * @param accountType
     * @param accountName
     */
    public Account(String userId, AccountType accountType, String accountName) {
        this(UUID.randomUUID().toString(), userId, accountType, accountName);
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

    public String getAccountName() {
        return _accountName;
    }

}
