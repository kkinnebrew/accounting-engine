package com.orangelit.stocktracker.web1.config;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;

@Singleton
public class MyInitializer {

    @Inject
    public MyInitializer(final PersistService service) {
        service.start();
    }

}
