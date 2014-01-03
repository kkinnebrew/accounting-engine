package com.orangelit.stocktracker.accounting.access;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AccountTypes")
public class AccountTypeEntity {

    @Id
    private String transactionTypeId;

    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    @Column(nullable = false)
    private Boolean direction;

    public Boolean getDirection() {
        return direction;
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
