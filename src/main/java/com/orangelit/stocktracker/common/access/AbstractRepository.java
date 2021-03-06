package com.orangelit.stocktracker.common.access;

import com.google.inject.Inject;

import javax.persistence.EntityManager;

public abstract class AbstractRepository {

    @Inject
    private EntityManager _entityManager;

    protected EntityManager getEntityManager() {
        return _entityManager;
    }

}
