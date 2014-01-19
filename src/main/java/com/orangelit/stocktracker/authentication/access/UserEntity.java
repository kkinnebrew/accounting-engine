package com.orangelit.stocktracker.authentication.access;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    public String userId;

    @Column(nullable = false)
    public String firstName;

    @Column(nullable = false)
    public String lastName;

    @NaturalId
    @Column(nullable = false)
    public String email;

    @JsonIgnore
    @Column(nullable = false)
    public String password;

    @Column(nullable = false)
    public Boolean isActive;

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
