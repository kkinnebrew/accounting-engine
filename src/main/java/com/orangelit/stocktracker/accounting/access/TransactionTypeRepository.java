package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.TransactionType;
import com.orangelit.stocktracker.common.access.BaseRepository;

public class TransactionTypeRepository extends BaseRepository<TransactionTypeEntity, TransactionType> {

    @Override
    protected TransactionType mapResult(TransactionTypeEntity entity) {
        return new TransactionType(entity.getTransactionTypeId(), entity.getName());
    }

    @Override
    protected TransactionTypeEntity mapInput(TransactionType model) {
        TransactionTypeEntity entity = new TransactionTypeEntity();
        entity.setTransactionTypeId(model.getTransactionTypeId());
        entity.setName(model.getName());
        return entity;
    }

    @Override
    protected Class<TransactionTypeEntity> getEntityClass() {
        return TransactionTypeEntity.class;
    }

}
