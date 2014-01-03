package com.orangelit.stocktracker.accounting.mock;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.common.access.BaseRepository;

public class EnumPopulator extends BaseRepository {

    @Inject
    public EnumPopulator() throws Exception {
        loadData();
    }

    @Transactional
    public void loadData() throws Exception {
//        for (AccountType accountType : AccountType.values()) {
//            getEntityManager().persist(accountType);
//        }
//        for (TransactionType transactionType : TransactionType.values()) {
//            getEntityManager().persist(transactionType);
//        }
    }

}
