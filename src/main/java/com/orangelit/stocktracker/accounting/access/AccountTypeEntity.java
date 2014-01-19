package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "AccountTypes")
public class AccountTypeEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String accountTypeId;

    @NaturalId
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountCategoryId")
    public AccountCategoryEntity accountCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentAccountTypeId")
    private AccountTypeEntity parentAccountType;


    // Getters & Setters

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountCategoryEntity getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(AccountCategoryEntity accountCategory) {
        this.accountCategory = accountCategory;
    }

    public AccountTypeEntity getParentAccountType() {
        return parentAccountType;
    }

    public void setParentAccountType(AccountTypeEntity parentAccountType) {
        this.parentAccountType = parentAccountType;
    }

}
