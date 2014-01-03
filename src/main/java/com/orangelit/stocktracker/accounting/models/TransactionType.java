package com.orangelit.stocktracker.accounting.models;

import java.util.UUID;

/**
 * A model representing a transaction type.
 */
public class TransactionType {

    // Private Fields

    private String _transactionTypeId;
    private String _name;

    // Constructors

    /**
     * @param transactionTypeId
     * @param name
     */
    public TransactionType(String transactionTypeId, String name) {

        _transactionTypeId = transactionTypeId;
        _name = name;

    }

    /**
     * @param name
     */
    public TransactionType(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    // Getters & Setters

    public String getTransactionTypeId() {
        return _transactionTypeId;
    }

    public String getName() {
        return _name;
    }
}
