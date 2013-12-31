package com.orangelit.stocktracker.authentication.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    @Id
    public String userId;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public Boolean isActive;

    public User(String firstName, String lastName, String email, String password) {

    }

}
