package com.orangelit.stocktracker.web.dtos;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.TransactionType;

import java.math.BigDecimal;
import java.util.Date;

public class AccountTransactionDTO {

    private String transactionId;
    private Date transactionDate;
    private TransactionType transactionType;
    private Account account;
    private BigDecimal amount;
    private BigDecimal balance;

    public AccountTransactionDTO(String transactionId,
                                 Date transactionDate,
                                 TransactionType transactionType,
                                 Account account,
                                 BigDecimal amount,
                                 BigDecimal balance) {

        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
