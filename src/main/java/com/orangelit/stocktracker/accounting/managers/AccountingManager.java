package com.orangelit.stocktracker.accounting.managers;

import com.orangelit.stocktracker.accounting.models.*;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;
import com.orangelit.stocktracker.common.exceptions.ItemNotFoundException;
import com.orangelit.stocktracker.common.exceptions.PersistenceException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AccountingManager {

    public List<AccountCategory> getAccountCategories();

    public List<Transaction> getTransactions(String accountId) throws InvalidInputException;

    public List<Transaction> getTransactionsForAccountType(String accountTypeId) throws InvalidInputException;

    public List<AccountType> getAccountTypes();

    public AccountType getAccountType(String accountId)  throws ItemNotFoundException;

    public AccountType createAccountType(String accountTypeName, String accountCategoryId, String parentAccountTypeId) throws InvalidInputException, PersistenceException;

    public AccountType updateAccountType(String accountTypeId, String accountTypeName, String accountCategoryId, String parentAccountTypeId) throws InvalidInputException, PersistenceException;

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

    public void createTransfer(String fromAccountId, String toAccountId, String transactionTypeId, Date transactionDate, BigDecimal amount, String description) throws InvalidInputException, PersistenceException;

    public void removeTransaction(String transactionId) throws InvalidInputException, ItemNotFoundException, PersistenceException;

    public BigDecimal getBalanceForAccount(String accountId) throws ItemNotFoundException, InvalidInputException;

    public BigDecimal getBalanceForAccount(Account account) throws ItemNotFoundException, InvalidInputException;

    public BigDecimal getBalanceForAccountType(String accountTypeId) throws ItemNotFoundException, InvalidInputException;

    public BigDecimal getBalanceForAccountType(AccountType accountType) throws ItemNotFoundException, InvalidInputException;

}
