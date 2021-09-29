package ir.maktab56.airline.repository.impl;

import ir.maktab56.airline.base.repository.impl.BaseRepositoryImpl;
import ir.maktab56.airline.domain.AirLine;
import ir.maktab56.airline.repository.AirLineRepository;

import javax.persistence.EntityManager;

public class AirLineRepositoryImpl extends BaseRepositoryImpl<AirLine, Long> implements AirLineRepository {
    public AirLineRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<AirLine> getEntityClass() {
        return AirLine.class;
    }


}
