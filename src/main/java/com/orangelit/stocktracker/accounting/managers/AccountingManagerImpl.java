package com.orangelit.stocktracker.accounting.managers;

import com.google.inject.Inject;
import com.orangelit.stocktracker.accounting.access.AccountRepository;
import com.orangelit.stocktracker.accounting.access.AccountTypeRepository;
import com.orangelit.stocktracker.accounting.access.TransactionLineRepository;
import com.orangelit.stocktracker.accounting.access.TransactionRepository;
import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.accounting.models.Transaction;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;
import com.orangelit.stocktracker.common.exceptions.PersistenceException;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class AccountingManagerImpl implements AccountingManager {
//
//    @Inject
//    private AccountRepository accountRepository;
//
//    @Inject
//    private TransactionRepository transactionRepository;
//
//    @Inject
//    private TransactionLineRepository transactionLineRepository;

    @Inject
    private AccountTypeRepository accountTypeRepository;

    public List<Transaction> getTransactions(Account account) throws InvalidInputException {
        return getTransactions(account.getAccountId());
    }

    public List<Transaction> getTransactions(String accountId) throws InvalidInputException {

        if (StringUtils.isEmpty(accountId)) {
            throw new InvalidInputException("Invalid account Id");
        }

//        List<Transaction> transaction = transactionRepository.getTransactions(accountId);

        return null;
    }

    public void createTransaction(Transaction transaction) throws InvalidInputException {



    }

    public void batchCreateTransactions(List<Transaction> transactions) throws InvalidInputException {

    }

    public List<AccountType> getAccountTypes() {
        return accountTypeRepository.getAll();
    }

    public AccountType createAccountType(String accountTypeName, Boolean direction)
            throws InvalidInputException, PersistenceException
    {
        AccountType accountType = new AccountType(accountTypeName, direction);
        return accountTypeRepository.create(accountType);
    }

    public AccountType updateAccountType(String accountTypeId, String accountTypeName, Boolean direction)
            throws InvalidInputException, PersistenceException
    {
        AccountType accountType = new AccountType(accountTypeId, accountTypeName, direction);
        return accountTypeRepository.update(accountType, accountTypeId);
    }

    public void removeAccountType(String accountTypeId)
            throws InvalidInputException, PersistenceException {
        accountTypeRepository.remove(accountTypeId);
    }

}
