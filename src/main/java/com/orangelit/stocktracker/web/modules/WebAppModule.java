package com.orangelit.stocktracker.web.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.googlecode.htmleasy.HtmleasyProviders;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManagerImpl;
import com.orangelit.stocktracker.authentication.mock.UserPopulator;
import com.orangelit.stocktracker.web.config.PersistenceInitializer;
import com.orangelit.stocktracker.web.resources.DashboardResource;
import com.orangelit.stocktracker.web.resources.AuthenticationResource;

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

        binder.bind(AuthenticationManager.class).to(AuthenticationManagerImpl.class);
        binder.bind(AuthenticationResource.class);
        binder.bind(DashboardResource.class);
    }
}