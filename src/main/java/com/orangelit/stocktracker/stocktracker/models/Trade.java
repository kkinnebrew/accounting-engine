package com.orangelit.stocktracker.stocktracker.models;

import com.orangelit.stocktracker.accounting.models.Transaction;

import java.util.Date;
import java.util.UUID;

public class Trade {

    // Private Fields

    private String tradeId;
    private Transaction transaction;
    private Security security;
    private Date created;


    // Constructors

    public Trade(String tradeId, Transaction transaction, Security security, Date created) {
        this.tradeId = tradeId;
        this.transaction = transaction;
        this.security = security;
        this.created = created;
    }

    public Trade(Transaction transaction, Security security) {
        this.tradeId = UUID.randomUUID().toString();
        this.transaction = transaction;
        this.security = security;
    }


    // Getters & Setters

    public String getTradeId() {
        return tradeId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public Date getCreated() {
        return created;
    }

}
