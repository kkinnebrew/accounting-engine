package com.orangelit.stocktracker.authentication.mock;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.authentication.exceptions.DuplicateUserException;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.common.access.BaseRepository;

import javax.persistence.EntityManager;

public class UserPopulator extends BaseRepository {

    private AuthenticationManager authenticationManager;

    @Inject
    public UserPopulator(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        try {
            loadData();
        } catch(Exception e) {}
    }

    @Transactional
    public void loadData() throws Exception {
        authenticationManager.register("Kevin", "Kinnebrew", "kevin.kinnebrew@gmail.com", "test", "test");
    }

}
