package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TransactionLines")
public class TransactionLineEntity extends TimestampedEntity {

    @Id
    private String transactionLineId;

    public String getTransactionLineId() {
        return transactionLineId;
    }

    public void setTransactionLineId(String transactionLineId) {
        this.transactionLineId = transactionLineId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private AccountEntity account;

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal debitAmount;

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal creditAmount;

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transactionId")
    @Cascade({CascadeType.REFRESH})
    private TransactionEntity transaction;

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    @Column(nullable = true)
    private Date created;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

    @Column(nullable = true)
    private Date updated;

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
