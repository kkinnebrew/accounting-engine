package com.orangelit.stocktracker.accounting.models;

import java.util.UUID;

public class AccountCategory {

    // Private Fields

    private String _accountCategoryId;
    private String _name;
    private Boolean _direction;

    // Constructors

    public AccountCategory(String accountCategoryId, String name, Boolean direction) {

        _accountCategoryId = accountCategoryId;
        _name = name;
        _direction = direction;

    }

    public AccountCategory(String name, Boolean direction) {
        this(UUID.randomUUID().toString(), name, direction);
    }

    // Getters & Setters

    public String getAccountCategoryId() {
        return _accountCategoryId;
    }

    public String getName() {
        return _name;
    }

    public Boolean getDirection() {
        return _direction;
    }

}
