package com.orangelit.stocktracker.accounting.models;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * A class representing individual lines of a transaction. Each line handles a
 * transfer from one account to another. All lines must some up to zero for a transaction
 * to be considered valid.
 * @author kkinnebrew
 */
public class TransactionLine {

    // Private Fields

    private String _transactionLineId;
    private Transaction _transaction;
    private Account _account;
    private BigDecimal _debitAmount;
    private BigDecimal _creditAmount;

    // Constructors

    public TransactionLine(String transactionLineId, Transaction transaction, Account account, BigDecimal debitAmount, BigDecimal creditAmount) {

        _transactionLineId = transactionLineId;
        _transaction = transaction;
        _account = account;
        _debitAmount = debitAmount != null ? debitAmount : BigDecimal.ZERO;
        _creditAmount = creditAmount != null ? creditAmount : BigDecimal.ZERO;

    }

    public TransactionLine(Transaction transaction, Account account, BigDecimal debitAmount, BigDecimal creditAmount) {
        this(UUID.randomUUID().toString(), transaction, account, debitAmount, creditAmount);
    }

    // Getters & Setters

    public String getTransactionLineId() {
        return _transactionLineId;
    }

    public Transaction getTransaction() {
        return _transaction;
    }

    public Account getAccount() {
        return _account;
    }

    public BigDecimal getDebitAmount() {
        return _debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return _creditAmount;
    }

}
