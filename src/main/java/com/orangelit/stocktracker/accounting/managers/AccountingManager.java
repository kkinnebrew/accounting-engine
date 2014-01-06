package com.orangelit.stocktracker.accounting.managers;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.accounting.models.Transaction;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;
import com.orangelit.stocktracker.common.exceptions.PersistenceException;

import java.util.List;

public interface AccountingManager {

    public List<Transaction> getTransactions(Account account) throws InvalidInputException;

    public List<Transaction> getTransactions(String accountId) throws InvalidInputException;

    public void createTransaction(Transaction transaction) throws InvalidInputException;

    public void batchCreateTransactions(List<Transaction> transactions) throws InvalidInputException;

    public List<AccountType> getAccountTypes();

    public AccountType createAccountType(String accountTypeName, Boolean direction, String parentAccountTypeId) throws InvalidInputException, PersistenceException;

    public AccountType updateAccountType(String accountTypeId, String accountTypeName, Boolean direction, String parentAccountTypeId) throws InvalidInputException, PersistenceException;

    public void removeAccountType(String accountTypeId) throws InvalidInputException, PersistenceException;

}
