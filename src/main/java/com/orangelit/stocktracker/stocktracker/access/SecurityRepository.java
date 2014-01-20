package com.orangelit.stocktracker.stocktracker.access;

import com.orangelit.stocktracker.common.access.BaseRepository;
import com.orangelit.stocktracker.stocktracker.models.Security;

public class SecurityRepository extends BaseRepository<SecurityEntity, Security> {

    @Override
    protected Security mapResult(SecurityEntity entity) {
        return SecurityRepository.mapResultStatic(entity);
    }

    @Override
    protected SecurityEntity mapInput(Security model) {
        return SecurityRepository.mapInputStatic(model);
    }

    @Override
    protected Class<SecurityEntity> getEntityClass() {
        return SecurityEntity.class;
    }

    protected static Security mapResultStatic(SecurityEntity entity) {
        return new Security(entity.getSecurityId(), entity.getSecurityName(), entity.getSymbol(), entity.getCreated());
    }

    protected static SecurityEntity mapInputStatic(Security model) {
        SecurityEntity entity = new SecurityEntity();
        entity.setSecurityId(model.getSecurityId());
        entity.setSecurityName(model.getSecurityName());
        entity.setSymbol(model.getSymbol());
        entity.setCreated(model.getCreated());
        return entity;
    }

}
