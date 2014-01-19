package com.orangelit.stocktracker.accounting.access;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.common.access.BaseRepository;

import javax.persistence.Query;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository extends BaseRepository<AccountEntity, Account> {

    @Override
    protected Account mapResult(AccountEntity entity) {
        return AccountRepository.mapResultStatic(entity);
    }

    @Override
    protected AccountEntity mapInput(Account model) {
        return AccountRepository.mapInputStatic(model);
    }

    @Override
    protected Class<AccountEntity> getEntityClass() {
        return AccountEntity.class;
    }

    protected static Account mapResultStatic(AccountEntity entity) {
        return new Account(entity.getAccountId(), entity.getUserId(),
                AccountTypeRepository.mapResultStatic(entity.getAccountType()), entity.getAccountName());
    }

    protected static AccountEntity mapInputStatic(Account model) {
        AccountEntity entity = new AccountEntity();
        entity.setAccountId(model.getAccountId());
        entity.setAccountName(model.getAccountName());
        entity.setUserId(model.getUserId());
        entity.setAccountType(AccountTypeRepository.mapInputStatic(model.getAccountType()));
        return entity;
    }

    public List<Account> getAccountsForUser(String userId) {
        String tableName = getEntityClass().getAnnotation(Table.class).name();
        getEntityManager().clear();
        Query query = getEntityManager().createNativeQuery("SELECT * FROM " + tableName + " WHERE userId = ?", getEntityClass());
        query.setParameter(1, userId);
        List results = query.getResultList();
        List<Account> mappedResults = new ArrayList<>();
        for (Object entity : results) {
            mappedResults.add(mapResult((AccountEntity)entity));
        }
        return mappedResults;
    }

}
