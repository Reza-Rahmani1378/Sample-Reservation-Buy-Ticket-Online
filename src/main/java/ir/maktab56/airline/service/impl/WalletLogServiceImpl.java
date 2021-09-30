package ir.maktab56.airline.service.impl;


import ir.maktab56.airline.base.service.impl.BaseServiceImpl;
import ir.maktab56.airline.domain.WalletLog;
import ir.maktab56.airline.repository.WalletLogRepository;
import ir.maktab56.airline.service.WalletLogService;

public class WalletLogServiceImpl extends BaseServiceImpl<WalletLog, Long, WalletLogRepository> implements
        WalletLogService {

    public WalletLogServiceImpl(WalletLogRepository repository) {
        super(repository);
    }

}
