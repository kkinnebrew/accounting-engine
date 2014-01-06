package com.orangelit.stocktracker.web.views;

import com.orangelit.stocktracker.accounting.models.TransactionType;
import com.orangelit.stocktracker.authentication.models.User;

import java.util.List;

public class TransactionTypeView {
    public User user;
    public List<TransactionType> transactionTypes;
    public String errorMessage;
}
