package com.orangelit.stocktracker.stocktracker.models;

import java.util.Date;
import java.util.UUID;

public class Security {

    // Private Fields

    private String securityId;
    private String securityName;
    private String symbol;
    private Date created;


    // Constructors

    public Security(String securityId, String securityName, String symbol, Date created) {
        this.securityId = securityId;
        this.securityName = securityName;
        this.symbol = symbol;
        this.created = created;
    }

    public Security(String securityName, String symbol) {
        this.securityId = UUID.randomUUID().toString();
        this.securityName = securityName;
        this.symbol = symbol;
    }


    // Getters & Setters

    public String getSecurityId() {
        return securityId;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getCreated() {
        return created;
    }

}
