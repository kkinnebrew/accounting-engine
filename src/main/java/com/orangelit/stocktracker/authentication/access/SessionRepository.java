package com.orangelit.stocktracker.authentication.access;

import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.common.access.BaseRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Date;
import java.util.UUID;

public class SessionRepository extends BaseRepository {

    @Transactional
    public String generateSession(User user, String hostname, Date expiration) {

        SessionEntity sessionEntity = new SessionEntity();

        sessionEntity.sessionId = UUID.randomUUID().toString();
        sessionEntity.userId = user.userId;
        sessionEntity.hostname = hostname;
        sessionEntity.expires = expiration;

        getEntityManager().persist(sessionEntity);

        return sessionEntity.sessionId;

    }

    public Boolean validateSession(String sessionId) {
        SessionEntity sessionEntity = getEntityManager().find(SessionEntity.class, sessionId);
        if (sessionEntity != null) {
            return sessionEntity.expires.compareTo(new Date()) > 0;
        } else {
            return false;
        }
    }

    @Transactional
    public void expireSession(String sessionId) {
        SessionEntity sessionEntity = getEntityManager().find(SessionEntity.class, sessionId);
        if (sessionEntity != null) {
            getEntityManager().remove(sessionEntity);
        }
    }

}
