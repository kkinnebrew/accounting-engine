package com.orangelit.stocktracker.accounting.models;

import com.orangelit.stocktracker.accounting.enumerations.TransactionType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Class representing a Transaction object.
 * @author kkinnebrew
 */
public class Transaction {

    // Private Fields

    private String _transactionId;
    private Date _transactionDate;
    private TransactionType _transactionType;
    private String _description;
    private List<TransactionLine> _transactionLines;

    // Constructors

    /**
     * @param transactionDate
     * @param transactionType
     * @param description
     */
    public Transaction(Date transactionDate, TransactionType transactionType, String description) {
        this(UUID.randomUUID().toString(), transactionDate, transactionType, description);
    }

    /**
     * @param transactionDate
     * @param transactionType
     * @param description
     */
    public Transaction(String transactionId, Date transactionDate, TransactionType transactionType, String description) {

        _transactionId = transactionId;
        _transactionDate = transactionDate;
        _transactionType = transactionType;
        _description = description;
        _transactionLines = new ArrayList<TransactionLine>();

    }

    /**
     * Adds a line to the transaction
     * @param transactionLine
     */
    public void addLine(TransactionLine transactionLine) {
        _transactionLines.add(transactionLine);
    }

    // Getters & Setters

    public String getTransactionId() {
        return _transactionId;
    }

    public Date getTransactionDate() {
        return _transactionDate;
    }

    public TransactionType getTransactionType() {
        return _transactionType;
    }

    public String getDescription() {
        return _description;
    }

    public List<TransactionLine> getTransactionLines() {
        return _transactionLines;
    }

    // Public Methods

    /**
     * Validates the transaction for accounting purposes
     * @return
     */
    public Boolean isValid() {

        if (_transactionLines.size() == 0) {
            return false;
        }

        BigDecimal sum = BigDecimal.ZERO;

        for (TransactionLine line : _transactionLines) {
            if (line.getDebitAmount() != null && line.getDebitAmount().compareTo(BigDecimal.ZERO) != 0) {
                sum = sum.add(line.getDebitAmount());
            }
            if (line.getCreditAmount() != null && line.getCreditAmount().compareTo(BigDecimal.ZERO) != 0) {
                sum = sum.subtract(line.getCreditAmount());
            }
        }

        return sum.compareTo(BigDecimal.ZERO) == 0;

    }

}
