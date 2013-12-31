package com.orangelit.stocktracker.web.modules;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.orangelit.stocktracker.authentication.access.SessionRepository;
import com.orangelit.stocktracker.web.config.MyInitializer;

public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("mysql-persistence"));
        bind(MyInitializer.class).asEagerSingleton();
        bind(SessionRepository.class);
    }

}