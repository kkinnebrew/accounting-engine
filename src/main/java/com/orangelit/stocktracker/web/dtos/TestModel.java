package com.orangelit.stocktracker.web.dtos;

import org.codehaus.jackson.annotate.JsonIgnore;

public class TestModel {

    private String _firstName;
    private String _lastName;

    public TestModel(String firstName, String lastName) {
        _firstName = firstName;
        _lastName = lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    @JsonIgnore
    public String getLastName() {
        return _lastName;
    }

}
