package com.orangelit.stocktracker.stocktracker.managers;

import com.google.inject.Inject;
import com.orangelit.stocktracker.accounting.managers.AccountingManager;
import com.orangelit.stocktracker.common.exceptions.ItemNotFoundException;
import com.orangelit.stocktracker.common.exceptions.PersistenceException;
import com.orangelit.stocktracker.stocktracker.access.PortfolioRepository;
import com.orangelit.stocktracker.stocktracker.models.Portfolio;

import java.util.List;

public class InvestmentManagerImpl implements InvestmentManager {

    @Inject
    private PortfolioRepository portfolioRepository;

    @Inject
    private AccountingManager accountingManager;

    public List<Portfolio> getPortfolios(String userId) {
        return portfolioRepository.getPortfoliosForUser(userId);
    }

    public Portfolio createPortfolio(String portfolioName, String userId) throws PersistenceException {

        // create accounts

        Portfolio portfolio = new Portfolio(portfolioName, userId);
        return portfolioRepository.create(portfolio);
    }

    public Portfolio updatePortfolio(String portfolioId, String portfolioName, String userId) throws PersistenceException, ItemNotFoundException {
        Portfolio portfolio = portfolioRepository.get(portfolioId);
        portfolio.setPortfolioName(portfolioName);
        portfolio.setUserId(userId);
        return portfolioRepository.update(portfolio, portfolioId);
    }

    public void removePortfolio(String portfolioId) throws PersistenceException {
        portfolioRepository.remove(portfolioId);
    }

}
