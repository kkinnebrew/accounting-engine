package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.common.access.BaseRepository;

public class AccountRepository extends BaseRepository<AccountEntity, Account> {

    @Override
    protected Account mapResult(AccountEntity entity) {
        return new Account(entity.getAccountId(), entity.getUserId(),
                AccountTypeRepository.mapResultStatic(entity.getAccountType()), entity.getAccountName());
    }

    @Override
    protected AccountEntity mapInput(Account model) {
        AccountEntity entity = new AccountEntity();
        entity.setAccountId(model.getAccountId());
        entity.setAccountName(model.getAccountName());
        entity.setUserId(model.getUserId());
        entity.setAccountType(AccountTypeRepository.mapInputStatic(model.getAccountType()));
        return entity;
    }

    @Override
    protected Class<AccountEntity> getEntityClass() {
        return AccountEntity.class;
    }

}
