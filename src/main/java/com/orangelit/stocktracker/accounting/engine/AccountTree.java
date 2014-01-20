package com.orangelit.stocktracker.accounting.engine;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.accounting.models.AccountType;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class AccountTree {

    private AccountNode root = null;

    public AccountTree(List<AccountType> accountTypes, List<Account> accounts) {

        LinkedList<AccountType> queue = new LinkedList<>(accountTypes);

        while (!queue.isEmpty()) {

            if (root == null) {
                root = new AccountNode(queue.removeFirst());
            } else if (root.getAccountType().getParentAccountType() != null && root.getAccountType().getParentAccountType().getAccountTypeId().equals(queue.getFirst().getAccountTypeId())) {
                AccountNode node = new AccountNode(queue.removeFirst());
                node.addChildAccountNode(root);
                root = node;
            } else if (traverse(root, queue.getFirst())) {
                queue.removeFirst();
            } else {
                queue.addLast(queue.removeFirst());
            }

        }

        for (Account account : accounts) {
            insert(root, account);
        }

    }

    public BigDecimal getBalance() {
        return root.getBalance();
    }

    private static Boolean traverse(AccountNode root, AccountType account) {

        if (account.getParentAccountType() != null && root.getAccountType().getAccountTypeId().equals(account.getParentAccountType().getAccountTypeId())) {
            root.addChildAccountNode(new AccountNode(account));
            return true;
        } else {
            for (AccountNode node : root.getChildAccountNodes()) {
                if (traverse(node, account)) {
                    return true;
                }
            }
        }

        return false;

    }

    private static Boolean insert(AccountNode root, Account account) {

        if (root.getAccountType().getAccountTypeId().equals(account.getAccountType().getAccountTypeId())) {
            root.addAccount(account);
            return true;
        } else {
            for (AccountNode node : root.getChildAccountNodes()) {
                if (insert(node, account)) {
                    return true;
                }
            }
        }

        return false;

    }

}