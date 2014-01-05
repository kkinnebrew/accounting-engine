package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AccountTypes")
public class AccountTypeEntity extends TimestampedEntity {

    @Id
    private String accountTypeId;

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    private Boolean direction;

    public Boolean getDirection() {
        return direction;
    }

    public void setDirection(Boolean direction) {
        this.direction = direction;
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
