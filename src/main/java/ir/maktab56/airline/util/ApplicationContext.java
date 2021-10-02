package ir.maktab56.airline.util;


import ir.maktab56.airline.repository.*;
import ir.maktab56.airline.repository.impl.*;
import ir.maktab56.airline.service.*;
import ir.maktab56.airline.service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final UserRepository userRepository;
    private static final CustomerRepository customerRepository;
    private static final AirLineRepository airLineRepository;
    private static final WalletRepository walletRepository;
    private static final WalletLogRepository walletLogRepository;
    private static final TicketRepository ticketRepository;
    private static final AirLineOperatorRepository airLineoperatorRepository;
    private static final UserService userService;
    private static final CustomerService customerService;
    private static final AirLineService airLineService;
    private static final TicketService ticketService;
    private static final WalletService walletService;
    private static final WalletLogService walletLogService;
    private static final AirLineOperatorService airLineoperatorService;


    static {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        userRepository = new UserRepositoryImpl(entityManager);
        userService = new UserServiceImpl(userRepository);

        walletLogRepository = new WalletLogRepositoryImpl(entityManager);
        walletLogService = new WalletLogServiceImpl(walletLogRepository);

        walletRepository = new WalletRepositoryImpl(entityManager);
        walletService = new WalletServiceImpl(walletRepository, walletLogService);

        customerRepository = new CustomerRepositoryImpl(entityManager);
        customerService = new CustomerServiceImpl(customerRepository, walletService);


        airLineRepository = new AirLineRepositoryImpl(entityManager);
        airLineService = new AirLineServiceImpl(airLineRepository);

        ticketRepository = new TicketRepositoryImpl(entityManager);
        ticketService = new TicketServiceImpl(ticketRepository);

        airLineoperatorRepository = new AirLineOperatorRepositoryImpl(entityManager);
        airLineoperatorService = new AirLineOperatorServiceImpl(airLineoperatorRepository);


    }

    public static UserService getUserService() {
        return userService;
    }

    public static CustomerService getCustomerService() {
        return customerService;
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

    public static AirLineOperatorService getAirLineoperatorService() {
        return airLineoperatorService;
    }
}
