package com.orangelit.stocktracker.common.access;

import com.google.inject.Inject;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.sql.Connection;

public abstract class BaseRepository {

    @Inject
    private EntityManager _entityManager;

    protected EntityManager getEntityManager() {
        return _entityManager;
    }

}
