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
    private String _transactionId;
    private String _accountId;
    private BigDecimal _debitAmount;
    private BigDecimal _creditAmount;

    // Constructors

    /**
     * @param transactionId
     * @param accountId
     * @param debitAmount
     * @param creditAmount
     */
    public TransactionLine(String transactionId, String accountId, BigDecimal debitAmount, BigDecimal creditAmount) {
        this(UUID.randomUUID().toString(), transactionId, accountId, debitAmount, creditAmount);
    }

    /**
     * @param transactionLineId
     * @param transactionId
     * @param accountId
     * @param debitAmount
     * @param creditAmount
     */
    public TransactionLine(String transactionLineId, String transactionId, String accountId, BigDecimal debitAmount, BigDecimal creditAmount) {

        _transactionLineId = transactionLineId;
        _transactionId = transactionId;
        _accountId = accountId;
        _debitAmount = debitAmount != null ? debitAmount : BigDecimal.ZERO;
        _creditAmount = creditAmount != null ? creditAmount : BigDecimal.ZERO;

    }

    /**
     * @param transaction
     * @param accountId
     * @param debitAmount
     * @param creditAmount
     */
    public TransactionLine(Transaction transaction, String accountId, BigDecimal debitAmount, BigDecimal creditAmount) {
        this(UUID.randomUUID().toString(), transaction.getTransactionId(), accountId, debitAmount, creditAmount);
    }

    // Getters & Setters

    public String getTransactionLineId() {
        return _transactionLineId;
    }

    public String getTransactionId() {
        return _transactionId;
    }

    public String getAccountId() {
        return _accountId;
    }

    public BigDecimal getDebitAmount() {
        return _debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return _creditAmount;
    }

}
