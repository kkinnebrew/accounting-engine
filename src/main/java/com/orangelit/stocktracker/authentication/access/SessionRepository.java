package com.orangelit.stocktracker.authentication.access;

import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.common.access.AbstractRepository;

import java.util.Date;
import java.util.UUID;

public class SessionRepository extends AbstractRepository {

    @Transactional
    public String generateSession(User user, String hostname, Date expiration) {

        SessionEntity sessionEntity = new SessionEntity();

        sessionEntity.setSessionId(UUID.randomUUID().toString());
        sessionEntity.setUserId(user.getUserId());
        sessionEntity.setHostname(hostname);
        sessionEntity.setExpires(expiration);

        System.out.println("Session generated for " + sessionEntity.getHostname());

        getEntityManager().persist(sessionEntity);

        return sessionEntity.getSessionId();

    }

    public Boolean validateSession(String sessionId) {
        SessionEntity sessionEntity = getEntityManager().find(SessionEntity.class, sessionId);
        return sessionEntity != null && sessionEntity.getExpires().compareTo(new Date()) > 0;
    }

    @Transactional
    public void expireSession(String sessionId) {
        SessionEntity sessionEntity = getEntityManager().find(SessionEntity.class, sessionId);
        if (sessionEntity != null) {
            getEntityManager().remove(sessionEntity);
        }
    }

}