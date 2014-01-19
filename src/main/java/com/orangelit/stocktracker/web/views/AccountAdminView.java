package com.orangelit.stocktracker.web.views;

import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.web.dtos.AccountDTO;

import java.util.List;

public class AccountAdminView {
    public User user;
    public List<AccountDTO> accounts;
    public List<AccountType> accountTypes;
}
