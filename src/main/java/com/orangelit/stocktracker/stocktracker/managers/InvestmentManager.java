package com.orangelit.stocktracker.stocktracker.managers;

import com.orangelit.stocktracker.common.exceptions.ItemNotFoundException;
import com.orangelit.stocktracker.common.exceptions.PersistenceException;
import com.orangelit.stocktracker.stocktracker.models.Portfolio;

import java.util.List;

public interface InvestmentManager {

    public List<Portfolio> getPortfolios(String userId);

    public Portfolio createPortfolio(String portfolioName, String userId) throws PersistenceException;

    public Portfolio updatePortfolio(String portfolioId, String portfolioName, String userId) throws PersistenceException, ItemNotFoundException;

    public void removePortfolio(String portfolioId) throws PersistenceException, ItemNotFoundException;

}
