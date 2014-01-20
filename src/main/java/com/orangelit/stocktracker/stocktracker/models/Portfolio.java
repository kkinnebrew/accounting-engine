package com.orangelit.stocktracker.stocktracker.models;

import com.orangelit.stocktracker.accounting.models.Account;
import com.orangelit.stocktracker.stocktracker.models.accounts.*;

import java.util.Date;
import java.util.List;
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

    public List<Holding> getHoldings() {
        return null;
    }

    public AccruedLongTermGainsTaxAccount getAccuredLongTermGainsTaxAccount() {
        return null;
    }

    public AccruedShortTermGainsTaxAccount getAccuredShortTermGainsTaxAccount() {
        return null;
    }

    public InvestmentAssetAccount getInvestmentAssetAccount() {
        return null;
    }

    public InvestmentCashAccount getInvestmentCashAccount() {
        return null;
    }

    public LongTermGainsTaxExpenseAccount getLongTermGainsTaxExpenseAccount() {
        return null;
    }

    public ShortTermGainsTaxExpenseAccount getShortTermGainsTaxExpenseAccount() {
        return null;
    }

    public RealizedLongTermGainsAccount getRealizedLongTermGainsAccount() {
        return null;
    }

    public RealizedShortTermGainsAccount getRealizedShortTermGainsAccount() {
        return null;
    }

    public UnrealizedLongTermGainsAccount getUnrealizedLongTermGainsAccount() {
        return null;
    }

    public UnrealizedShortTermGainsAccount getUnrealizedShortTermGainsAccount() {
        return null;
    }

}
