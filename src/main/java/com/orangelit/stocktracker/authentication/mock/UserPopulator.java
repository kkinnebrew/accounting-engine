package com.orangelit.stocktracker.authentication.mock;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.common.access.BaseRepository;

import javax.persistence.EntityManager;

public class UserPopulator extends BaseRepository {

    private EntityManager entityManager;

    @Inject
    public UserPopulator(EntityManager entityManager) {
        this.entityManager = entityManager;
        loadData();
    }

    @Transactional
    public void loadData() {
        entityManager.persist(new User("Kevin", "Kinnebrew", "kevin.kinnebrew@gmail.com", "test"));
    }

}
