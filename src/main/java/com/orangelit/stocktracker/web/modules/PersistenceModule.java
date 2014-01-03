package com.orangelit.stocktracker.web.modules;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.orangelit.stocktracker.accounting.access.*;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.accounting.managers.AccountingManagerImpl;
import com.orangelit.stocktracker.authentication.access.SessionRepository;
import com.orangelit.stocktracker.authentication.access.UserRepository;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManagerImpl;
import com.orangelit.stocktracker.authentication.mock.UserPopulator;
import com.orangelit.stocktracker.web.config.MyInitializer;

public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {

        install(new JpaPersistModule("mysql-persistence"));

        bind(MyInitializer.class).asEagerSingleton();
        bind(UserPopulator.class).asEagerSingleton();

        // accounting

        bind(AccountRepository.class).to(AccountRepositoryImpl.class);
//        bind(AccountTypeRepository.class);
//        bind(TransactionRepository.class);
//        bind(TransactionLineRepository.class);
//        bind(TransactionTypeRepository.class);

        bind(AccountingManager.class).to(AccountingManagerImpl.class);

        // authentication

        bind(SessionRepository.class);
        bind(UserRepository.class);

        bind(AuthenticationManager.class).to(AuthenticationManagerImpl.class);
    }

}