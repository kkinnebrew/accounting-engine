package com.orangelit.stocktracker.web.dtos;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.TransactionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AccountTransactionDTO {

    private String transactionId;
    private Date transactionDate;
    private TransactionType transactionType;
    private List<Account> accounts;
    private String description;
    private BigDecimal amount;
    private BigDecimal balance;

    public AccountTransactionDTO(String transactionId,
                                 Date transactionDate,
                                 TransactionType transactionType,
                                 List<Account> accounts,
                                 String description,
                                 BigDecimal amount,
                                 BigDecimal balance) {

        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.accounts = accounts;
        this.description = description;
        this.amount = amount;
        this.balance = balance;

    }

    public String getTransactionId() {
        return transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getAccountsString() {
        StringBuilder builder = new StringBuilder();
        for (Account account : accounts) {
            if (!builder.toString().isEmpty()) {
                builder.append(", ");
            }
            builder.append(account.getAccountName());
        }
        return builder.toString();
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
