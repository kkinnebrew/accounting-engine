package com.orangelit.stocktracker.common.access;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class TimestampedEntity {

    @Column(nullable = true)
    private Date created;

    @Column(nullable = true)
    private Date updated;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    private void setUpdated(Date updated) {
        this.updated = updated;
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
