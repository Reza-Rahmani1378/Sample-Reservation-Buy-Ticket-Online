package ir.maktab56.airline.repository.impl;

import ir.maktab56.airline.base.repository.impl.BaseRepositoryImpl;
import ir.maktab56.airline.domain.WalletLog;
import ir.maktab56.airline.repository.WalletLogRepository;

import javax.persistence.EntityManager;

public class WalletLogRepositoryImpl extends BaseRepositoryImpl<WalletLog, Long> implements WalletLogRepository {
    public WalletLogRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<WalletLog> getEntityClass() {
        return WalletLog.class;
    }


}
