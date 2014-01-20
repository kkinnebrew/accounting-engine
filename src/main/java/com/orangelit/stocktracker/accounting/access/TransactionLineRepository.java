package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.TransactionLine;
import com.orangelit.stocktracker.common.access.BaseRepository;

public class TransactionLineRepository extends BaseRepository<TransactionLineEntity, TransactionLine> {

    @Override
    protected TransactionLine mapResult(TransactionLineEntity entity) {
        return TransactionLineRepository.mapResultStatic(entity);
    }

    @Override
    protected TransactionLineEntity mapInput(TransactionLine model) {
        return TransactionLineRepository.mapInputStatic(model);
    }

    @Override
    protected Class<TransactionLineEntity> getEntityClass() {
        return TransactionLineEntity.class;
    }

    protected static TransactionLine mapResultStatic(TransactionLineEntity entity, Boolean mapChildren) {
        return new TransactionLine(entity.getTransactionLineId(), TransactionRepository.mapResultStatic(entity.getTransaction(), false), mapChildren ? AccountRepository.mapResultStatic(entity.getAccount()) : null, entity.getDebitAmount(), entity.getCreditAmount());
    }

    protected static TransactionLine mapResultStatic(TransactionLineEntity entity) {
        return mapResultStatic(entity, true);
    }

    protected static TransactionLineEntity mapInputStatic(TransactionLine model, Boolean mapChildren) {
        TransactionLineEntity entity = new TransactionLineEntity();
        entity.setTransactionLineId(model.getTransactionLineId());
        entity.setTransaction(TransactionRepository.mapInputStatic(model.getTransaction(), false));
        if (mapChildren) {
            entity.setAccount(AccountRepository.mapInputStatic(model.getAccount()));
        }
        entity.setDebitAmount(model.getDebitAmount());
        entity.setCreditAmount(model.getCreditAmount());
        return entity;
    }

    protected static TransactionLineEntity mapInputStatic(TransactionLine model) {
        return mapInputStatic(model, true);
    }

}
