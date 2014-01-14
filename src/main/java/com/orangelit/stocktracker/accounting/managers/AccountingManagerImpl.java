package com.orangelit.stocktracker.accounting.managers;

import com.google.inject.Inject;
import com.orangelit.stocktracker.accounting.access.*;
import com.orangelit.stocktracker.accounting.models.*;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;
import com.orangelit.stocktracker.common.exceptions.ItemNotFoundException;
import com.orangelit.stocktracker.common.exceptions.PersistenceException;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class AccountingManagerImpl implements AccountingManager {

    @Inject
    private AccountRepository accountRepository;

    @Inject
    private TransactionRepository transactionRepository;

    @Inject
    private TransactionLineRepository transactionLineRepository;

    @Inject
    private TransactionTypeRepository transactionTypeRepository;

    @Inject
    private AccountTypeRepository accountTypeRepository;

    public List<Transaction> getTransactions(String accountId) throws InvalidInputException {

        if (StringUtils.isEmpty(accountId)) {
            throw new InvalidInputException("Invalid account Id");
        }

        return transactionRepository.getTransactionsForAccount(accountId);
    }

    public List<Transaction> getTransactionsForAccountType(String accountTypeId) throws InvalidInputException {

        if (StringUtils.isEmpty(accountTypeId)) {
            throw new InvalidInputException("Invalid account Id");
        }

        return null;//transactionRepository.getTransactionsForAccountType(accountTypeId);
    }


    public List<AccountType> getAccountTypes() {
        List<AccountType> accountTypes = accountTypeRepository.getAll();
        Collections.sort(accountTypes, new Comparator<AccountType>() {
            @Override
            public int compare(AccountType o1, AccountType o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return accountTypes;
    }

    public AccountType getAccountType(String accountId) throws ItemNotFoundException {
       return accountTypeRepository.get(accountId);
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
        List<TransactionType> types = transactionTypeRepository.getAll();
        Collections.sort(types, new Comparator<TransactionType>() {
            @Override
            public int compare(TransactionType o1, TransactionType o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return types;
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
        List<Account> accounts = accountRepository.getAll();
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getAccountName().compareTo(o2.getAccountName());
            }
        });
        return accounts;
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

    public void createTransfer(String debitAccountId, String creditAccountId, String transactionTypeId, Date transactionDate, BigDecimal amount, String description) throws InvalidInputException, PersistenceException {

        try
        {
            TransactionType transactionType = transactionTypeRepository.get(transactionTypeId);
            Account debitAccount = accountRepository.get(debitAccountId);
            Account creditAccount = accountRepository.get(creditAccountId);

            Transaction transaction = new Transaction(transactionDate, transactionType, description);

            transaction.addLine(new TransactionLine(transaction, debitAccount, amount, BigDecimal.ZERO));
            transaction.addLine(new TransactionLine(transaction, creditAccount, BigDecimal.ZERO, amount));

            transactionRepository.create(transaction);

            for (TransactionLine line : transaction.getTransactionLines())
            {
                transactionLineRepository.create(line);
            }
        }
        catch (ItemNotFoundException ex) {
            throw new InvalidInputException("Cannot find account type with id " + transactionTypeId);
        }
        catch (Exception e) {
            throw new InvalidInputException("Cannot find account type with id " + transactionTypeId);
        }

    }

    public void removeTransaction(String transactionId) throws InvalidInputException, ItemNotFoundException, PersistenceException {

        Transaction transaction = transactionRepository.get(transactionId);

        for (TransactionLine line : transaction.getTransactionLines()) {
            transactionLineRepository.remove(line.getTransactionLineId());
        }

        transactionRepository.remove(transactionId);

    }

    public BigDecimal getBalanceForAccount(String accountId) throws ItemNotFoundException, InvalidInputException {
        Account account = getAccount(accountId);
        return getBalanceForAccount(account);
    }

    public BigDecimal getBalanceForAccount(Account account) throws ItemNotFoundException, InvalidInputException {

        List<Transaction> transactions = getTransactions(account.getAccountId());

        BigDecimal balance = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            for (TransactionLine transactionLine : transaction.getTransactionLines()) {
                if (!transactionLine.getAccount().getAccountId().equals(account.getAccountId())) {
                    continue;
                }
                if (account.getAccountType().getDirection()) {
                    balance = balance.add(transactionLine.getDebitAmount());
                    balance = balance.subtract(transactionLine.getCreditAmount());
                } else {
                    balance = balance.subtract(transactionLine.getDebitAmount());
                    balance = balance.add(transactionLine.getCreditAmount());
                }
            }
        }

        return balance;
    }

    public BigDecimal getBalanceForAccountType(String accountTypeId) throws ItemNotFoundException, InvalidInputException {
        AccountType accountType = getAccountType(accountTypeId);
        return getBalanceForAccountType(accountType);
    }

    public BigDecimal getBalanceForAccountType(AccountType accountType) throws ItemNotFoundException, InvalidInputException {

        List<Transaction> transactions = getTransactionsForAccountType(accountType.getAccountTypeId());

        BigDecimal balance = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            for (TransactionLine transactionLine : transaction.getTransactionLines()) {
                if (!transactionLine.getAccount().getAccountId().equals(transactionLine.getAccount().getAccountId())) {
                    continue;
                }
                if (transactionLine.getAccount().getAccountType().getDirection()) {
                    balance = balance.add(transactionLine.getDebitAmount());
                    balance = balance.subtract(transactionLine.getCreditAmount());
                } else {
                    balance = balance.subtract(transactionLine.getDebitAmount());
                    balance = balance.add(transactionLine.getCreditAmount());
                }
            }
        }

        return balance;

    }
}
