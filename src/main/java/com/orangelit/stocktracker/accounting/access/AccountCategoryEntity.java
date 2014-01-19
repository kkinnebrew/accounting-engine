package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "AccountCategories")
public class AccountCategoryEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String accountCategoryId;

    @NaturalId
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean direction;


    // Getters & Setters

    public String getAccountCategoryId() {
        return accountCategoryId;
    }

    public void setAccountCategoryId(String accountCategoryId) {
        this.accountCategoryId = accountCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDirection() {
        return direction;
    }

    public void setDirection(Boolean direction) {
        this.direction = direction;
    }

}
