package com.orangelit.stocktracker.accounting.access;

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
    public String accountTypeId;

    @Column(nullable = true)
    private Date created;

    @Column(nullable = true)
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
