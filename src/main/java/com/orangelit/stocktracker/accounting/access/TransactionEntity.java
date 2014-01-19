package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Transactions")
public class TransactionEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "transactionTypeId") @Cascade({CascadeType.REFRESH})
    private TransactionTypeEntity transactionType;

    @Column(nullable = false)
    private Date transactionDate;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "transaction")
    @Cascade({CascadeType.REFRESH})
    private List<TransactionLineEntity> transactionLines;


    // Getters & Setters

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionTypeEntity getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEntity transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TransactionLineEntity> getTransactionLines() {
        return transactionLines;
    }

    public void setTransactionLines(List<TransactionLineEntity> transactionLines) {
        this.transactionLines = transactionLines;
    }

}
