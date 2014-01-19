package com.orangelit.stocktracker.authentication.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sessions")
public class SessionEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String sessionId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String hostname;

    @Column(nullable = false)
    private Date expires;


    // Getters & Setters

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }
    
}
