package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.AccountCategory;
import com.orangelit.stocktracker.common.access.BaseRepository;

public class AccountCategoryRepository extends BaseRepository<AccountCategoryEntity, AccountCategory> {

    @Override
    protected AccountCategory mapResult(AccountCategoryEntity entity) {
        return AccountCategoryRepository.mapResultStatic(entity);
    }

    @Override
    protected AccountCategoryEntity mapInput(AccountCategory model) {
        return AccountCategoryRepository.mapInputStatic(model);
    }

    @Override
    protected Class<AccountCategoryEntity> getEntityClass() {
        return AccountCategoryEntity.class;
    }

    protected static AccountCategory mapResultStatic(AccountCategoryEntity entity) {
        return new AccountCategory(entity.getAccountCategoryId(), entity.getName(), entity.getDirection());
    }

    protected static AccountCategoryEntity mapInputStatic(AccountCategory model) {
        AccountCategoryEntity entity = new AccountCategoryEntity();
        entity.setAccountCategoryId(model.getAccountCategoryId());
        entity.setName(model.getName());
        entity.setDirection(model.getDirection());
        return entity;
    }

}
