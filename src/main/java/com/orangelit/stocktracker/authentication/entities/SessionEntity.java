package com.orangelit.stocktracker.authentication.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sessions")
public class SessionEntity {

    @Id
    public String sessionId;

    @Column(nullable = false)
    public String userId;

    @Column(nullable = false)
    public String hostname;

    @Column(nullable = false)
    public Date expires;

    @Column(nullable = true)
    private Date created;

    @Column(nullable = true)
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
