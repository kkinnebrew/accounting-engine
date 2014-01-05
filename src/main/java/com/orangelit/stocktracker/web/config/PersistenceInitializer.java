package com.orangelit.stocktracker.web.config;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;

@Singleton
public class PersistenceInitializer {

    @Inject
    public PersistenceInitializer(final PersistService service) {
        service.start();
    }

}
