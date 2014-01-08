package com.orangelit.stocktracker.accounting.managers;

import com.google.inject.Inject;
import com.orangelit.stocktracker.accounting.access.*;
import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.accounting.models.Transaction;
import com.orangelit.stocktracker.accounting.models.TransactionType;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;
import com.orangelit.stocktracker.common.exceptions.ItemNotFoundException;
import com.orangelit.stocktracker.common.exceptions.PersistenceException;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountingManagerImpl implements AccountingManager {
//
    @Inject
    private AccountRepository accountRepository;

    @Inject
    private TransactionRepository transactionRepository;

    @Inject
    private TransactionTypeRepository transactionTypeRepository;

    @Inject
    private AccountTypeRepository accountTypeRepository;

    public List<Transaction> getTransactions(Account account) throws InvalidInputException {
        return getTransactions(account.getAccountId());
    }

    public List<Transaction> getTransactions(String accountId) throws InvalidInputException {

        if (StringUtils.isEmpty(accountId)) {
            throw new InvalidInputException("Invalid account Id");
        }

        return transactionRepository.getTransactionsForAccount(accountId);
    }

    public void createTransaction(Transaction transaction) throws InvalidInputException {



    }

    public void batchCreateTransactions(List<Transaction> transactions) throws InvalidInputException {

    }

    public List<AccountType> getAccountTypes() {
        return accountTypeRepository.getAll();
    }

    public AccountType createAccountType(String accountTypeName, Boolean direction, String parentAccountTypeId)
            throws InvalidInputException, PersistenceException
    {
        AccountType accountType = null;
        AccountType parentAccountType = null;
        if (!StringUtils.isEmpty(parentAccountTypeId)) {
            try {
                parentAccountType = accountTypeRepository.get(parentAccountTypeId);
                accountType = new AccountType(accountTypeName, parentAccountType.getDirection(), parentAccountType);
            } catch (ItemNotFoundException ex) {
                throw new InvalidInputException("Cannot find account type with id " + parentAccountTypeId);
            }
        } else {
            accountType = new AccountType(accountTypeName, direction, null);
        }
        return accountTypeRepository.create(accountType);
    }

    public AccountType updateAccountType(String accountTypeId, String accountTypeName, Boolean direction, String parentAccountTypeId)
            throws InvalidInputException, PersistenceException
    {
        AccountType accountType = null;
        AccountType parentAccountType = null;
        if (!StringUtils.isEmpty(parentAccountTypeId)) {
            if (parentAccountTypeId.equals(accountTypeId)) {
                throw new InvalidInputException("AccountType cannot reference itself as parent");
            }
            try {
                parentAccountType = accountTypeRepository.get(parentAccountTypeId);
                accountType = new AccountType(accountTypeId, accountTypeName, parentAccountType.getDirection(), parentAccountType);
            } catch (ItemNotFoundException ex) {
                throw new InvalidInputException("Cannot find account type with id " + parentAccountTypeId);
            }
        } else {
            accountType = new AccountType(accountTypeId, accountTypeName, direction, parentAccountType);
        }
        return accountTypeRepository.update(accountType, accountTypeId);
    }

    public void removeAccountType(String accountTypeId)
            throws InvalidInputException, PersistenceException {
        accountTypeRepository.remove(accountTypeId);
    }

    public List<TransactionType> getTransactionTypes() {
        return transactionTypeRepository.getAll();
    }

    public TransactionType createTransactionType(String transactionTypeName)
            throws InvalidInputException, PersistenceException {
        TransactionType transactionType = new TransactionType(transactionTypeName);
        return transactionTypeRepository.create(transactionType);
    }

    public TransactionType updateTransactionType(String transactionTypeId, String transactionTypeName)
            throws InvalidInputException, PersistenceException {
        TransactionType transactionType = new TransactionType(transactionTypeId, transactionTypeName);
        return transactionTypeRepository.update(transactionType, transactionTypeId);
    }

    public void removeTransactionType(String transactionTypeId) throws InvalidInputException, PersistenceException {
        transactionTypeRepository.remove(transactionTypeId);
    }

    public List<Account> getAccounts() {
        return accountRepository.getAll();
    }

    public Account getAccount(String accountId) throws ItemNotFoundException {
        return accountRepository.get(accountId);
    }

    public Account createAccount(String accountName, String accountTypeId, String userId) throws InvalidInputException, PersistenceException {
        try {
            AccountType accountType = accountTypeRepository.get(accountTypeId);
            Account account = new Account(userId, accountType, accountName);
            return accountRepository.create(account);
        } catch (ItemNotFoundException ex) {
            throw new InvalidInputException("Cannot find account type with id " + accountTypeId);
        }
    }

    public Account updateAccount(String accountId, String accountName, String accountTypeId, String userId) throws InvalidInputException, PersistenceException {
        try {
            AccountType accountType = accountTypeRepository.get(accountTypeId);
            Account account = new Account(accountId, userId, accountType, accountName);
            return accountRepository.update(account, accountId);
        } catch (ItemNotFoundException ex) {
            throw new InvalidInputException("Cannot find account type with id " + accountTypeId);
        }
    }

    public void removeAccount(String accountId) throws InvalidInputException, PersistenceException {
        accountRepository.remove(accountId);
    }

}
