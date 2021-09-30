package ir.maktab56.airline.service;

import ir.maktab56.airline.base.service.BaseService;
import ir.maktab56.airline.domain.Customer;
import ir.maktab56.airline.domain.Ticket;
import ir.maktab56.airline.domain.dto.WalletChangeDTO;
import ir.maktab56.airline.domain.enumeration.UserType;

public interface CustomerService extends BaseService<Customer, Long> {

    Boolean isIncreaseWalletAmount(WalletChangeDTO wct , UserType userType) throws Exception;

    Boolean isDecreaseWalletAmountWithBuyTicket(WalletChangeDTO wct , Ticket ticket);

}
