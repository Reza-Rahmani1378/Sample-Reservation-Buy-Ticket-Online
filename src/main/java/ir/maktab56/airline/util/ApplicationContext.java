package ir.maktab56.airline.util;


import ir.maktab56.airline.repository.AirLineRepository;
import ir.maktab56.airline.repository.TicketRepository;
import ir.maktab56.airline.repository.UserRepository;
import ir.maktab56.airline.repository.WalletRepository;
import ir.maktab56.airline.repository.impl.AirLineRepositoryImpl;
import ir.maktab56.airline.repository.impl.TicketRepositoryImpl;
import ir.maktab56.airline.repository.impl.UserRepositoryImpl;
import ir.maktab56.airline.repository.impl.WalletRepositoryImpl;
import ir.maktab56.airline.service.AirLineService;
import ir.maktab56.airline.service.TicketService;
import ir.maktab56.airline.service.UserService;
import ir.maktab56.airline.service.WalletService;
import ir.maktab56.airline.service.impl.AirLineServiceImpl;
import ir.maktab56.airline.service.impl.TicketServiceImpl;
import ir.maktab56.airline.service.impl.UserServiceImpl;
import ir.maktab56.airline.service.impl.WalletServiceImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final UserRepository userRepository;
    private static final AirLineRepository airLineRepository;
    private static final WalletRepository walletRepository;
    private static final TicketRepository ticketRepository;
    private static final UserService userService;
    private static final AirLineService airLineService;
    private static final TicketService ticketService;
    private static final WalletService walletService;



    static {
            EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
            userRepository = new UserRepositoryImpl(entityManager);
            userService = new UserServiceImpl(userRepository);

            walletRepository = new WalletRepositoryImpl(entityManager);
            walletService = new WalletServiceImpl(walletRepository);

            airLineRepository = new AirLineRepositoryImpl(entityManager);
            airLineService = new AirLineServiceImpl(airLineRepository);

            ticketRepository = new TicketRepositoryImpl(entityManager);
            ticketService = new TicketServiceImpl(ticketRepository);
    }

    public static UserService getUserService() {
        return userService;
    }

    public static TicketService getTicketService() {
        return ticketService;
    }

    public static WalletService getWalletService() {
        return walletService;
    }

    public static AirLineService getAirLineService() {
        return airLineService;
    }

}
