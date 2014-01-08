package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.TransactionType;
import com.orangelit.stocktracker.common.access.BaseRepository;

public class TransactionTypeRepository extends BaseRepository<TransactionTypeEntity, TransactionType> {

    @Override
    protected TransactionType mapResult(TransactionTypeEntity entity) {
        return TransactionTypeRepository.mapResultStatic(entity);
    }

    @Override
    protected TransactionTypeEntity mapInput(TransactionType model) {
        return TransactionTypeRepository.mapInputStatic(model);
    }

    @Override
    protected Class<TransactionTypeEntity> getEntityClass() {
        return TransactionTypeEntity.class;
    }

    protected static TransactionType mapResultStatic(TransactionTypeEntity entity) {
        return new TransactionType(entity.getTransactionTypeId(), entity.getName());
    }

    protected static TransactionTypeEntity mapInputStatic(TransactionType model) {
        TransactionTypeEntity entity = new TransactionTypeEntity();
        entity.setTransactionTypeId(model.getTransactionTypeId());
        entity.setName(model.getName());
        return entity;
    }

}
