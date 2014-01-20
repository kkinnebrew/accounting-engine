package com.orangelit.stocktracker.accounting.models;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
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
    private List<TransactionLine> transactionLines;

    // Constructors

    public Account(String accountId, String userId, AccountType accountType, String accountName) {

        _accountId = accountId;
        _userId = userId;
        _accountType = accountType;
        _accountName = accountName;
        transactionLines = new LinkedList<>();

    }

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

    public BigDecimal getBalance() {

        BigDecimal balance = BigDecimal.ONE;

        if (_accountType.getAccountCategory().getDirection()) {

            for (TransactionLine line : transactionLines) {
                balance = balance.add(line.getDebitAmount());
                balance = balance.subtract(line.getCreditAmount());
            }

        } else {

            for (TransactionLine line : transactionLines) {
                balance = balance.subtract(line.getDebitAmount());
                balance = balance.add(line.getCreditAmount());
            }

        }

        return balance;
    }

    public void addTransactionLine(TransactionLine line) {
        transactionLines.add(line);
    }

    public List<TransactionLine> getTransactionLines() {
        return transactionLines;
    }

}
