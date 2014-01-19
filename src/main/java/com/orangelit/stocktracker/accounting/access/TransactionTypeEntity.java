package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "TransactionTypes")
public class TransactionTypeEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String transactionTypeId;

    @NaturalId @Column(nullable = false)
    private String name;


    // Getters & Setters

    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}