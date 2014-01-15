package com.orangelit.stocktracker.web.views;

import com.orangelit.stocktracker.accounting.models.AccountCategory;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.web.dtos.AccountTypeDTO;

import java.util.List;

public class AccountTypeAdminView {
    public User user;
    public List<AccountTypeDTO> accountTypes;
    public List<AccountCategory> accountCategories;
    public String errorMessage;
}
