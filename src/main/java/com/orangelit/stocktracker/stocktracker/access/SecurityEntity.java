package com.orangelit.stocktracker.stocktracker.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Id;

public class SecurityEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String securityId;

    @Column(nullable = false)
    private String securityName;

    @NaturalId @Column(nullable = false)
    private String symbol;


    // Getters & Setters

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
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

}
