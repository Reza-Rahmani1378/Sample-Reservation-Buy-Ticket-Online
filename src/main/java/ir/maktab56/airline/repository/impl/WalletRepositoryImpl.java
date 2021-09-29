package ir.maktab56.airline.repository.impl;

import ir.maktab56.airline.base.repository.impl.BaseRepositoryImpl;
import ir.maktab56.airline.domain.Wallet;
import ir.maktab56.airline.repository.WalletRepository;

import javax.persistence.EntityManager;

public class WalletRepositoryImpl extends BaseRepositoryImpl<Wallet, Long> implements WalletRepository {
    public WalletRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Wallet> getEntityClass() {
        return Wallet.class;
    }


}
