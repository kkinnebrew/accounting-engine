package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Accounts")
public class AccountEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String accountId;

    @Column(nullable = false)
    private String accountName;

    @Column(nullable = false)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountTypeId")
    private AccountTypeEntity accountType;

    @OneToMany(mappedBy = "account")
    @Cascade({org.hibernate.annotations.CascadeType.REFRESH})
    private List<TransactionLineEntity> transactionLines;


    // Getters & Setters

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AccountTypeEntity getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeEntity accountType) {
        this.accountType = accountType;
    }

    public List<TransactionLineEntity> getTransactionLines() {
        return transactionLines;
    }

}
