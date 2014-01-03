package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.enumerations.TransactionType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Transactions")
public class TransactionEntity {

    @Id
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Column(nullable = false)
    private Date transactionDate;

    public Date getTransactionDate() {
        return transactionDate;
    }

    @Column(nullable = false)
    private String description;

    public String getDescription() {
        return description;
    }

    @OneToMany(mappedBy = "transaction")
    private List<TransactionLineEntity> transactionLines;

    public List<TransactionLineEntity> getTransactionLines() {
        return transactionLines;
    }

    @Column(nullable = true)
    private Date created;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @Column(nullable = true)
    private Date updated;

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
