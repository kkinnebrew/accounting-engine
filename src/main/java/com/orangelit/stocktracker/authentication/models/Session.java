package com.orangelit.stocktracker.authentication.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Sessions")
public class Session {

    @Id
    public String sessionId;
    public String userId;
    public String hostname;
    public Date expires;

    public Session(String userId, String hostname) {

        sessionId = UUID.randomUUID().toString();
        userId = userId;
        hostname = hostname;

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 30);

        expires = cal.getTime();

    }

    public String getToken() {
        return sessionId;
    }

}
