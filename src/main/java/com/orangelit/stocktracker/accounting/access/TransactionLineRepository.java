package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.TransactionLine;

public class TransactionLineRepository {

    protected static TransactionLine mapResultStatic(TransactionLineEntity entity) {
        return new TransactionLine(entity.getTransactionLineId(), TransactionRepository.mapResultStatic(entity.getTransaction(), false), AccountRepository.mapResultStatic(entity.getAccount()), entity.getDebitAmount(), entity.getCreditAmount());
    }

    protected static TransactionLineEntity mapInputStatic(TransactionLine model) {
        TransactionLineEntity entity = new TransactionLineEntity();
        entity.setTransactionLineId(model.getTransactionLineId());
        entity.setTransaction(TransactionRepository.mapInputStatic(model.getTransaction(), false));
        entity.setAccount(AccountRepository.mapInputStatic(model.getAccount()));
        entity.setDebitAmount(model.getDebitAmount());
        entity.setCreditAmount(model.getCreditAmount());
        return entity;
    }

}
