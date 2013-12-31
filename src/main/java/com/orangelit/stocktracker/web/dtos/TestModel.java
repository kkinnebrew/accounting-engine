package com.orangelit.stocktracker.web.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TestModels")
public class TestModel {

    @Id
    private int id;

    private String name;

    private Date created;

    public TestModel(int id, String name, Date created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreated() {
        return created;
    }

}
