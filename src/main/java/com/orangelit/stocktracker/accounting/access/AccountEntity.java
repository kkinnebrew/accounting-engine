package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.enumerations.AccountType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Accounts")
public class AccountEntity {

    @Id
    public String accountId;

    @Column(nullable = false)
    public String userId;

    @Column(nullable = false)
    public String accountName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public AccountType accountType;

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
