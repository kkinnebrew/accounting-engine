package com.orangelit.stocktracker.stocktracker.access;

import com.orangelit.stocktracker.common.access.BaseRepository;
import com.orangelit.stocktracker.stocktracker.models.Portfolio;

public class PortfolioRepository extends BaseRepository<PortfolioEntity, Portfolio> {

    @Override
    protected Portfolio mapResult(PortfolioEntity entity) {
        return PortfolioRepository.mapResultStatic(entity);
    }

    @Override
    protected PortfolioEntity mapInput(Portfolio model) {
        return PortfolioRepository.mapInputStatic(model);
    }

    @Override
    protected Class<PortfolioEntity> getEntityClass() {
        return PortfolioEntity.class;
    }

    protected static Portfolio mapResultStatic(PortfolioEntity entity) {
        return new Portfolio(entity.getPortfolioId(), entity.getPortfolioName(), entity.getUserId(), entity.getCreated());
    }

    protected static PortfolioEntity mapInputStatic(Portfolio model) {
        PortfolioEntity entity = new PortfolioEntity();
        entity.setPortfolioId(model.getPortfolioId());
        entity.setPortfolioName(model.getPortfolioName());
        entity.setUserId(model.getUserId());
        entity.setCreated(model.getCreated());
        return entity;
    }

}
