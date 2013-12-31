package com.orangelit.stocktracker.authentication.access;

import com.orangelit.stocktracker.authentication.models.Session;
import com.orangelit.stocktracker.common.access.BaseRepository;

public class SessionRepository extends BaseRepository {

    public String generateSession() {
        Session session = new Session("!@312", "1.03.2.2311");
        getEntityManager().persist(session);
        return session.getToken();
    }

    public Boolean validateSession(String sessionId) {
        return true;
    }

    public void expireSession(String sessionId) {
        return;
    }

}
