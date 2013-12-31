package com.orangelit.stocktracker.common.access;

import com.google.inject.Inject;

import java.sql.Connection;

public class BaseRepository {

    private Connection _connection;

    @Inject
    public BaseRepository(Connection connection) {
        _connection = connection;
    }

}
