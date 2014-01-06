package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.AccountType;
import com.orangelit.stocktracker.common.access.BaseRepository;

public class AccountTypeRepository extends BaseRepository<AccountTypeEntity, AccountType> {

    @Override
    protected AccountType mapResult(AccountTypeEntity entity) {
        if (entity.getParentAccountType() != null) {
            return new AccountType(entity.getAccountTypeId(), entity.getName(), entity.getDirection(), mapResult(entity.getParentAccountType()));
        } else {
            return new AccountType(entity.getAccountTypeId(), entity.getName(), entity.getDirection(), null);
        }
    }

    @Override
    protected AccountTypeEntity mapInput(AccountType model) {
        AccountTypeEntity entity = new AccountTypeEntity();
        entity.setAccountTypeId(model.getAccountTypeId());
        entity.setName(model.getName());
        entity.setDirection(model.getDirection());
        if (model.getParentAccountType() != null) {
            entity.setParentAccountType(mapInput(model.getParentAccountType()));
        }
        return entity;
    }

    @Override
    protected Class<AccountTypeEntity> getEntityClass() {
        return AccountTypeEntity.class;
    }

}
