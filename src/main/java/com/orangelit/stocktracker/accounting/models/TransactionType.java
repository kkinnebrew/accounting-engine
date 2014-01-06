package com.orangelit.stocktracker.accounting.models;

import java.util.Date;
import java.util.UUID;

public class TransactionType {

    // Private Fields

    private String _transactionTypeId;
    private String _name;
    private Date _created;

    // Constructors

    public TransactionType(String transactionTypeId, String name) {
        _transactionTypeId = transactionTypeId;
        _name = name;
    }

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
