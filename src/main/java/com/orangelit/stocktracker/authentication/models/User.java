package com.orangelit.stocktracker.authentication.models;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Users")
public class User {

    @Id
    public String userId;

    public String firstName;

    public String lastName;

    public String email;

    @JsonIgnore
    public String password;

    public Boolean isActive;

    public User() {}

    public User(String firstName, String lastName, String email, String password) {

        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isActive = true;

    }

}
