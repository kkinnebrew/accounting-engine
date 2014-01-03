package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.Transaction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TransactionLineEntity {

    @Id
    private String transactionLineId;

    public String getTransactionLineId() {
        return transactionLineId;
    }

    @ManyToOne
    @JoinColumn(name = "transactionId")
    private TransactionEntity transaction;

    public TransactionEntity getTransaction() {
        return transaction;
    }

}
