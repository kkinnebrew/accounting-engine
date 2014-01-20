package com.orangelit.stocktracker.stocktracker.access;

import com.orangelit.stocktracker.accounting.access.TransactionEntity;
import com.orangelit.stocktracker.common.access.TimestampedEntity;

import javax.persistence.*;

@Entity
@Table(name = "Trades")
public class TradeEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String tradeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transactionId")
    private TransactionEntity transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "securityId")
    private SecurityEntity security;


    // Getters & Setters

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public SecurityEntity getSecurity() {
        return security;
    }

    public void setSecurity(SecurityEntity security) {
        this.security = security;
    }

}
