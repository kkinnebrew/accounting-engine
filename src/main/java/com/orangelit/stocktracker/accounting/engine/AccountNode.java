package com.orangelit.stocktracker.accounting.engine;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.AccountType;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class AccountNode {

    private List<AccountNode> childAccountTypes;
    private AccountType accountType;
    private List<Account> accounts;

    public AccountNode(AccountType accountType) {

        this.childAccountTypes = new LinkedList<>();
        this.accounts = new LinkedList<>();
        this.accountType = accountType;

    }

    public void addChildAccountNode(AccountNode accountNode) {
        childAccountTypes.add(accountNode);
    }

    public List<AccountNode> getChildAccountNodes() {
        return childAccountTypes;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public BigDecimal getBalance() {

        BigDecimal balance = BigDecimal.ZERO;

        for (AccountNode node : childAccountTypes) {
            balance.add(node.getBalance());
        }

        for (Account account : accounts) {
            balance.add(account.getBalance());
        }

        return balance;

    }

}