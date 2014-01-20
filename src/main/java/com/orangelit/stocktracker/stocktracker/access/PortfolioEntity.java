package com.orangelit.stocktracker.stocktracker.access;

import com.orangelit.stocktracker.common.access.TimestampedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Portfolios")
public class PortfolioEntity extends TimestampedEntity {

    // Private Fields

    @Id
    private String portfolioId;

    @Column(nullable = false)
    private String portfolioName;

    @Column(nullable = false)
    private String userId;


    // Getters & Setters

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
