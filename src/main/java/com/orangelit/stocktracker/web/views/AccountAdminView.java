package com.orangelit.stocktracker.web.views;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.authentication.models.User;

import java.util.List;

public class AccountAdminView {
    public User user;
    public List<Account> accounts;
    public List<AccountType> accountTypes;
    public String errorMessage;
}
