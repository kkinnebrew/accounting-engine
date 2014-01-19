package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.Transaction;
import com.orangelit.stocktracker.accounting.models.TransactionLine;
import com.orangelit.stocktracker.common.access.BaseRepository;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class TransactionRepository extends BaseRepository<TransactionEntity, Transaction> {

    @Override
    protected Transaction mapResult(TransactionEntity entity) {
        return TransactionRepository.mapResultStatic(entity);
    }

    @Override
    protected TransactionEntity mapInput(Transaction model) {
        return TransactionRepository.mapInputStatic(model);
    }

    @Override
    protected Class<TransactionEntity> getEntityClass() {
        return TransactionEntity.class;
    }

    protected static Transaction mapResultStatic(TransactionEntity entity) {
        return TransactionRepository.mapResultStatic(entity, true);
    }

    protected static Transaction mapResultStatic(TransactionEntity entity, Boolean mapChildren) {
        Transaction transaction = new Transaction(entity.getTransactionId(), entity.getTransactionDate(), TransactionTypeRepository.mapResultStatic(entity.getTransactionType()), entity.getDescription());
        if (mapChildren) {
            for (TransactionLineEntity lineEntity : entity.getTransactionLines()) {
                transaction.addLine(TransactionLineRepository.mapResultStatic(lineEntity));
            }
        }
        return transaction;
    }

    protected static TransactionEntity mapInputStatic(Transaction model) {
        return TransactionRepository.mapInputStatic(model, true);
    }

    protected static TransactionEntity mapInputStatic(Transaction model, Boolean mapChildren) {
        TransactionEntity entity = new TransactionEntity();
        entity.setTransactionId(model.getTransactionId());
        entity.setTransactionDate(model.getTransactionDate());
        entity.setDescription(model.getDescription());
        entity.setTransactionType(TransactionTypeRepository.mapInputStatic(model.getTransactionType()));
        List<TransactionLineEntity> lines = new LinkedList<>();
        if (mapChildren) {
            for (TransactionLine line : model.getTransactionLines()) {
                lines.add(TransactionLineRepository.mapInputStatic(line));
            }
        }
        entity.setTransactionLines(lines);
        return entity;
    }

    public List<Transaction> getTransactionsForAccount(String accountId) {

        Query query = getEntityManager().createNativeQuery("select T.*, TL.*, TT.* from Transactions T INNER JOIN TransactionLines TL ON T.transactionId = TL.transactionId INNER JOIN TransactionTypes TT ON TT.transactionTypeId = T.transactionTypeId WHERE TL.accountId = ?", TransactionEntity.class);
        query.setParameter(1, accountId);

        List results = query.getResultList();
        List<Transaction> transactions = new LinkedList<>();

        for (Object entity : results) {
            transactions.add(mapResult((TransactionEntity)entity));
        }

        return transactions;

    }

}

