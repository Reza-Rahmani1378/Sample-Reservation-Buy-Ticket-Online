package ir.maktab56.airline.repository.impl;

import ir.maktab56.airline.base.repository.impl.BaseRepositoryImpl;
import ir.maktab56.airline.domain.AirLineOperator;
import ir.maktab56.airline.repository.AirLineOperatorRepository;

import javax.persistence.EntityManager;

public class AirLineOperatorRepositoryImpl extends BaseRepositoryImpl<AirLineOperator, Long> implements AirLineOperatorRepository {
    public AirLineOperatorRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<AirLineOperator> getEntityClass() {
        return AirLineOperator.class;
    }


}
