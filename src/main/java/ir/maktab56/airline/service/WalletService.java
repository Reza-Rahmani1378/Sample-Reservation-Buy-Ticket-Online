package ir.maktab56.airline.service;

import ir.maktab56.airline.base.service.BaseService;
import ir.maktab56.airline.domain.Customer;
import ir.maktab56.airline.domain.Ticket;
import ir.maktab56.airline.domain.Wallet;
import ir.maktab56.airline.domain.dto.WalletChangeDTO;

public interface WalletService extends BaseService<Wallet, Long> {

    Boolean isIncreaseWalletAmount(WalletChangeDTO wct);

    Boolean isDecreaseWalletAmountWithBuyTicket(WalletChangeDTO wct, Ticket ticket, Customer customer);
}
