package com.orangelit.stocktracker.authentication.access;

import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.authentication.models.Session;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.common.access.BaseRepository;

import java.util.Date;

public class SessionRepository extends BaseRepository {

    @Transactional
    public String generateSession(User user, String hostname) {
        Session session = new Session(user.userId, hostname);
        getEntityManager().persist(session);
        return session.getToken();
    }

    public Boolean validateSession(String sessionId) {
        Session session = getEntityManager().find(Session.class, sessionId);
        if (session != null) {
            return session.expires.compareTo(new Date()) > 0;
        } else {
            return false;
        }
    }

    @Transactional
    public void expireSession(String sessionId) {
        Session session = getEntityManager().find(Session.class, sessionId);
        getEntityManager().remove(session);
    }

}
