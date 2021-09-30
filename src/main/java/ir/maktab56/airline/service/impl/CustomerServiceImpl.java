package ir.maktab56.airline.service.impl;


import ir.maktab56.airline.base.service.impl.BaseServiceImpl;
import ir.maktab56.airline.domain.Customer;
import ir.maktab56.airline.domain.Ticket;
import ir.maktab56.airline.domain.dto.WalletChangeDTO;
import ir.maktab56.airline.domain.enumeration.UserType;
import ir.maktab56.airline.repository.CustomerRepository;
import ir.maktab56.airline.service.CustomerService;
import ir.maktab56.airline.service.WalletService;
import ir.maktab56.airline.util.SecurityContext;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository> implements
        CustomerService {
    private final WalletService walletService;
    public CustomerServiceImpl(CustomerRepository repository, WalletService walletService) {
        super(repository);
        this.walletService = walletService;
    }

    @Override
    public Boolean isIncreaseWalletAmount(WalletChangeDTO wct, UserType userType) throws Exception {
        if (SecurityContext.getActiveUser().getUserType().equals(userType)) {
            if (repository.existById(wct.getCustomerId()))
                return walletService.isIncreaseWalletAmount(wct);
            else
                return false;
        }
        throw  new Exception();
    }

    @Override
    public Boolean isDecreaseWalletAmountWithBuyTicket(WalletChangeDTO wct, Ticket ticket) {
        Customer customer = repository.findById(wct.getCustomerId());
        if (customer.getWallet().getTotalAmount() >= wct.getAmount())
            return walletService.isDecreaseWalletAmountWithBuyTicket(wct , ticket , customer);
        else
            return false;
    }
}
