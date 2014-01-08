package com.orangelit.stocktracker.accounting.managers;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.accounting.models.Transaction;
import com.orangelit.stocktracker.accounting.models.TransactionType;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;
import com.orangelit.stocktracker.common.exceptions.ItemNotFoundException;
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

    public List<TransactionType> getTransactionTypes();

    public TransactionType createTransactionType(String transactionTypeName) throws InvalidInputException, PersistenceException;

    public TransactionType updateTransactionType(String transactionTypeId, String transactionTypeName) throws InvalidInputException, PersistenceException;

    public void removeTransactionType(String transactionTypeId) throws InvalidInputException, PersistenceException;

    public List<Account> getAccounts();

    public Account getAccount(String accountId) throws ItemNotFoundException;

    public Account createAccount(String accountName, String accountTypeId, String userId) throws InvalidInputException, PersistenceException;

    public Account updateAccount(String accountId, String accountName, String accountTypeId, String userId) throws InvalidInputException, PersistenceException;

    public void removeAccount(String accountId) throws InvalidInputException, PersistenceException;

}
