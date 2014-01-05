package com.orangelit.stocktracker.web.views;

import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.authentication.models.User;

import java.util.List;

public class AccountTypeAdminView {
    public User user;
    public List<AccountType> accountTypes;
    public String errorMessage;
}
