package com.orangelit.stocktracker.authentication.mock;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.authentication.managers.AuthenticationManager;
import com.orangelit.stocktracker.common.access.BaseRepository;

public class UserPopulator extends BaseRepository {

    private AuthenticationManager authenticationManager;

    @Inject
    public UserPopulator(AuthenticationManager authenticationManager) throws Exception {
        this.authenticationManager = authenticationManager;
        loadData();
    }

    @Transactional
    public void loadData() throws Exception {
        authenticationManager.register("Kevin", "Kinnebrew", "kevin.kinnebrew@gmail.com", "test", "test");
    }

}
