package com.orangelit.stocktracker.common.access;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.common.exceptions.ItemNotFoundException;
import com.orangelit.stocktracker.common.exceptions.PersistenceException;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<E extends TimestampedEntity, M> {

    @Inject
    private EntityManager _entityManager;

    protected EntityManager getEntityManager() {
        return _entityManager;
    }

    public List<M> getAll() {
        String tableName = getEntityClass().getAnnotation(Table.class).name();
        getEntityManager().clear();
        Query query = getEntityManager().createNativeQuery("SELECT * FROM " + tableName, getEntityClass());
        List<E> results = query.getResultList();
        List<M> mappedResults = new ArrayList<M>();
        for (E entity : results) {
            mappedResults.add(mapResult(entity));
        }
        return mappedResults;
    }

    public M get(String entityId) throws ItemNotFoundException {
        try {
            getEntityManager().clear();
            E entity = getEntityManager().find(getEntityClass(), entityId);
            if (entity != null) {
                return mapResult(entity);
            } else {
                throw new ItemNotFoundException(getEntityClass(), entityId);
            }
        } catch(Exception e) {
            throw new ItemNotFoundException(getEntityClass(), entityId);
        }
    }

    @Transactional
    public M create(M model) throws PersistenceException {
        try {
            getEntityManager().persist(mapInput(model));
            return model;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error creating entity");
        }
    }

    @Transactional
    public M update(M model, String entityId) throws PersistenceException {
        try {
            E entity = getEntityManager().find(getEntityClass(), entityId);
            E mappedEntity = mapInput(model);
            mappedEntity.setCreated(entity.getCreated());
            getEntityManager().merge(mappedEntity);
            return model;
        } catch(Exception e) {
            throw new PersistenceException("Error updating entity");
        }
    }

    @Transactional
    public void remove(String entityId) throws PersistenceException {
        String tableName = getEntityClass().getAnnotation(Table.class).name();
        Field[] fields = getEntityClass().getDeclaredFields();
        String tableIdField = null;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(Id.class)) {
                tableIdField = fields[i].getName();
            }
        }
        if (tableIdField == null) {
            throw new PersistenceException("Missing @Id annotation");
        }
        try {
            Query query = getEntityManager().createNativeQuery("DELETE FROM " + tableName + " WHERE " + tableIdField + "=:id LIMIT 1");
            query.setParameter("id", entityId);
            query.executeUpdate();
            getEntityManager().flush();
        } catch(Exception e) {
            throw new PersistenceException("Error removing entity");
        }
    }

    protected abstract M mapResult(E entity);

    protected abstract E mapInput(M model);

    protected abstract Class<E> getEntityClass();

}
