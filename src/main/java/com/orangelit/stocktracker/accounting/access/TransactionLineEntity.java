package com.orangelit.stocktracker.accounting.access;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TransactionLines")
public class TransactionLineEntity {

    @Id
    private String transactionLineId;

    public String getTransactionLineId() {
        return transactionLineId;
    }

    @ManyToOne
    @JoinColumn(name = "accountId")
    private AccountEntity account;

    public AccountEntity getAccount() {
        return account;
    }

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal debitAmount;

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal creditAmount;

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    @ManyToOne
    @JoinColumn(name = "transactionId")
    private TransactionEntity transaction;

    public TransactionEntity getTransaction() {
        return transaction;
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
