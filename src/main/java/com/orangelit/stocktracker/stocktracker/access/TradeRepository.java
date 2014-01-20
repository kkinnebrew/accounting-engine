package com.orangelit.stocktracker.stocktracker.access;

import com.orangelit.stocktracker.accounting.access.TransactionRepository;
import com.orangelit.stocktracker.common.access.BaseRepository;
import com.orangelit.stocktracker.stocktracker.models.Trade;

public class TradeRepository extends BaseRepository<TradeEntity, Trade> {

    @Override
    protected Trade mapResult(TradeEntity entity) {
        return TradeRepository.mapResultStatic(entity);
    }

    @Override
    protected TradeEntity mapInput(Trade model) {
        return TradeRepository.mapInputStatic(model);
    }

    @Override
    protected Class<TradeEntity> getEntityClass() {
        return TradeEntity.class;
    }

    protected static Trade mapResultStatic(TradeEntity entity) {
        return new Trade(entity.getTradeId(),
                         TransactionRepository.mapResultStatic(entity.getTransaction()),
                         SecurityRepository.mapResultStatic(entity.getSecurity()),
                         entity.getCreated());
    }

    protected static TradeEntity mapInputStatic(Trade model) {
        TradeEntity entity = new TradeEntity();
        entity.setTradeId(model.getTradeId());
        entity.setTransaction(TransactionRepository.mapInputStatic(model.getTransaction()));
        entity.setSecurity(SecurityRepository.mapInputStatic(model.getSecurity()));
        entity.setCreated(model.getCreated());
        return entity;
    }

}
