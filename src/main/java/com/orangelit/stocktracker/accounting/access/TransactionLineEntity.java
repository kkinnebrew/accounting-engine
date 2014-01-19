package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TransactionLines")
public class TransactionLineEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String transactionLineId;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "accountId")
    private AccountEntity account;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal debitAmount;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal creditAmount;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "transactionId") @Cascade({CascadeType.REFRESH})
    private TransactionEntity transaction;


    // Getters & Setters

    public String getTransactionLineId() {
        return transactionLineId;
    }

    public void setTransactionLineId(String transactionLineId) {
        this.transactionLineId = transactionLineId;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

}
