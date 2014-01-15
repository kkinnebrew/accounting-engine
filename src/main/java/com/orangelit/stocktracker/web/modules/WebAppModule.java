package com.orangelit.stocktracker.web.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.SessionScoped;
import com.googlecode.htmleasy.HtmleasyProviders;
import com.orangelit.stocktracker.accounting.access.*;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.accounting.managers.AccountingManagerImpl;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManagerImpl;
import com.orangelit.stocktracker.authentication.mock.UserPopulator;
import com.orangelit.stocktracker.web.config.PersistenceInitializer;
import com.orangelit.stocktracker.web.resources.*;

public class WebAppModule implements Module
{
    public void configure(final Binder binder)
    {
        for (Class<?> c : HtmleasyProviders.getClasses()) {
            binder.bind(c);
        }

        binder.install(new JpaPersistModule("mysql-persistence"));

        binder.bind(PersistenceInitializer.class).asEagerSingleton();
        binder.bind(UserPopulator.class).asEagerSingleton();

        binder.bind(AccountTypeRepository.class);
        binder.bind(AccountRepository.class);
        binder.bind(TransactionTypeRepository.class);
        binder.bind(TransactionRepository.class);
        binder.bind(TransactionLineRepository.class);
        binder.bind(AccountCategoryRepository.class);

        binder.bind(AuthenticationManager.class).to(AuthenticationManagerImpl.class);
        binder.bind(AccountingManager.class).to(AccountingManagerImpl.class);

        binder.bind(AuthenticationResource.class);
        binder.bind(DashboardResource.class);
        binder.bind(AccountingResource.class);
        binder.bind(AccountResource.class);
        binder.bind(AccountTypeResource.class);
        binder.bind(TransactionTypeResource.class);
        binder.bind(TransactionResource.class);

    }
}