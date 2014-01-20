package com.orangelit.stocktracker.stocktracker.models;

import java.util.Date;
import java.util.UUID;

public class Portfolio {

    // Private Fields

    private String portfolioId;
    private String portfolioName;
    private String userId;
    private Date created;


    // Constructors

    public Portfolio(String portfolioId, String portfolioName, String userId, Date created) {
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
        this.userId = userId;
        this.created = created;
    }

    public Portfolio(String portfolioName, String userId) {
        this.portfolioId = UUID.randomUUID().toString();
        this.portfolioName = portfolioName;
        this.userId = userId;
    }


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

    public Date getCreated() {
        return created;
    }

}
