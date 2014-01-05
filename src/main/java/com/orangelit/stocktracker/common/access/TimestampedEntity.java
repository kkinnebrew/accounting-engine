package com.orangelit.stocktracker.common.access;

import java.util.Date;

public abstract class TimestampedEntity {

    public abstract Date getCreated();

    public abstract void setCreated(Date created);

}
