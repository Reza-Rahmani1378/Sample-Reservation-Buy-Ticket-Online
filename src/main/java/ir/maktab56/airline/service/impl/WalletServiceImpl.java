package ir.maktab56.airline.service.impl;


import ir.maktab56.airline.base.service.impl.BaseServiceImpl;
import ir.maktab56.airline.domain.Wallet;
import ir.maktab56.airline.repository.WalletRepository;
import ir.maktab56.airline.service.WalletService;

public class WalletServiceImpl extends BaseServiceImpl<Wallet, Long, WalletRepository> implements
        WalletService {

    public WalletServiceImpl(WalletRepository repository) {
        super(repository);
    }

}
