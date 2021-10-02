package ir.maktab56.airline.util.menu;

import ir.maktab56.airline.domain.*;
import ir.maktab56.airline.domain.dto.TicketDto;
import ir.maktab56.airline.domain.dto.WalletChangeDTO;
import ir.maktab56.airline.domain.enumeration.UserType;
import ir.maktab56.airline.util.ApplicationContext;
import ir.maktab56.airline.util.SecurityContext;
import ir.maktab56.airline.util.input.Input;
import ir.maktab56.airline.util.input.InputInformation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RunMenu extends Menu {

    public RunMenu() {
        super(new String[]{"Login", "Sign Up", "Airline Company Panel", "Exit"});
    }


    public void run() throws Exception {
        while (true) {
            print();
            switch (chooseOperation()) {
                case 1:
                    User activeUser = ApplicationContext.getUserService().login();
                    if (!Objects.isNull(activeUser)) {
                        SecurityContext.setActiveUser(activeUser);
                        UserType userType = SecurityContext.getActiveUser().getUserType();
                        switch (userType) {
                            case ADMIN -> adminMenu();
                            case CUSTOMER -> {
                                Customer activeCustomer =
                                        ApplicationContext.getCustomerService().findById(activeUser.getId());
                                normalUserMenu(activeCustomer);

                            }

                        }
                    }

                    break;
                case 2:
                    ApplicationContext.getUserService().singUp();
                    break;

                case 3:
                    User airLineOperator = ApplicationContext.getUserService().login();
                    if (!Objects.isNull(airLineOperator)) {
                        SecurityContext.setActiveUser(airLineOperator);
                        AirLineOperator activeAirLineOp = ApplicationContext.getAirLineoperatorService().findById(airLineOperator.getId());
                        addTicket(activeAirLineOp);
                    }


                    break;
                case 4:
                    return;

            }
        }
    }

    private void addTicket(AirLineOperator airLineOperator) {
        System.out.println("Welcome to your workbench :" + airLineOperator.getAirLine().getName());
        while (true) {
            String from = new Input("Enter from :").getInputString();
            String to = new Input("Enter to :").getInputString();
            String departureDate = InputInformation.getDepartureDate();
            String take_off_time = new Input("Enter take-off time :").getInputString();
            String landing_time = new Input("Enter landing time :").getInputString();
            Long price = new Input("Enter price ticket :", Long.MAX_VALUE, 0L).getInputLong();
            Long valency = new Input("Enter capacity ticket :", Long.MAX_VALUE, 0L).getInputLong();
            Ticket ticket = new Ticket();
            ticket.setAir_line(airLineOperator.getAirLine());
            ticket.setStart_point(from);
            ticket.setEnd_point(to);
            ticket.setPrice_ticket(price);
            ticket.setDepart_time(departureDate);
            ticket.setTake_off_time(take_off_time);
            ticket.setLanding_time(landing_time);
            ticket.setValency(valency);
            ApplicationContext.getTicketService().save(ticket);
            System.out.println("Your service is added successfully.");
            System.out.println("Do you want add another service?");
            String[] checkStr = new String[]{"Yes", "No"};
            int option = new Input().chooseOption(checkStr);
            if (option == 1){
                System.out.println("Have a nice day.");
                break;
            }

            System.out.println("Add another service.");

        }


    }

    private void normalUserMenu(Customer activeCustomer) {
        String[] strings = new String[]{
                "One way", "Return", "log out"
        };
        while (true) {
            int choose = new Input().chooseOption(strings);
            switch (choose) {
                case 1:
                    List<Ticket> tickets = search();
                    System.out.println("Do you want filter tickets ?");
                    String[] checkStr = new String[]{"Yes", "No"};
                    int chooseCheck = new Input().chooseOption(checkStr);
                    if (chooseCheck == 1) {
                        filtering(tickets, activeCustomer, checkStr);
                    } else
                        buyTicket(activeCustomer, tickets, checkStr);
                    break;

                case 2:
                    break;
                case 3:
                    return;
            }

        }


    }

    private void buyTicket(Customer activeCustomer, List<Ticket> tickets, String[] checkStr) {
        ticketViewList(tickets);
        Long ticketId =
                new Input("Enter ticket id for buy :", Long.MAX_VALUE, 0L).getInputLong();

        try {
            Ticket ticket =
                    tickets.stream().filter(t -> t.getId().equals(ticketId)).collect(Collectors.toList()).get(0);
            if (ticket.getValency() > 0) {

                System.out.println(ticket.getPrice_ticket());
                WalletChangeDTO wct = new WalletChangeDTO();
                wct.setCustomerId(activeCustomer.getId());
                System.out.println("Do you want Buy this Ticket Cash?");
                int option = new Input().chooseOption(checkStr);
                wct.setCash(option == 1);
                wct.setAmount(ticket.getPrice_ticket());
                Boolean decreaseWalletAmountWithBuyTicket =
                        ApplicationContext.getCustomerService().isDecreaseWalletAmountWithBuyTicket(wct, ticket);
                if (decreaseWalletAmountWithBuyTicket) {
                    System.out.println("Your Buy Ticket Done Successfully...");
                    ticket.setValency(ticket.getValency() -1L);
                    activeCustomer.getTickets().add(ticket);
                    ApplicationContext.getCustomerService().save(activeCustomer);
                    ApplicationContext.getTicketService().save(ticket);
                } else {
                    System.out.println("Your Balance is not enough...");
                    System.out.println("You can Increase Wallet Amount By visiting the Admin");
                }

            } else
                System.out.println("This valency ticket is full...");
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong ID ...");
        }
    }

    private void filtering(List<Ticket> tickets, Customer activeCustomer, String[] checkStr) {
        String[] strings = new String[]{
                "Filter By Max Price", "Filter By Min Price", "Airline name", "Previous Menu"
        };
        int choose = new Input().chooseOption(strings);
        switch (choose) {
            case 1:
                List<Ticket> sortedTicketsByMaxPrice = ApplicationContext.getTicketService().sortedByPrice(1);
                ticketViewList(sortedTicketsByMaxPrice);
                buyTicket(activeCustomer, sortedTicketsByMaxPrice, checkStr);
                break;
            case 2:
                List<Ticket> sortedTicketsByMinPrice = ApplicationContext.getTicketService().sortedByPrice(2);
                ticketViewList(sortedTicketsByMinPrice);
                buyTicket(activeCustomer, sortedTicketsByMinPrice, checkStr);
                break;
            case 3:

                String name = new Input("Enter name Airline :").getInputString();
                List<Ticket> sortByAirLineName = ApplicationContext.getTicketService().sortByAirLineName(name);
                if (sortByAirLineName == null)
                    System.out.println("This airline is not exist.");
                assert sortByAirLineName != null;
                ticketViewList(sortByAirLineName);
                buyTicket(activeCustomer, sortByAirLineName, checkStr);
                break;
            case 4:
                return;

        }
    }

    private List<Ticket> search() {
        String from = new Input("Enter FROM :").getInputString();
        String to = new Input("Enter TO :").getInputString();
        String date = InputInformation.getDepartureDate();
        TicketDto ticketDto = new TicketDto(from, to, date);
        List<Ticket> tickets = ApplicationContext.getTicketService().searchByFromAndTo(ticketDto);
        ticketViewList(tickets);
        return tickets;
    }

    private void adminMenu() throws Exception {
        String[] strings = new String[]{
                "Add Airline Panel", "Increase Amount Customer", "Log out"
        };
        int choose = new Input().chooseOption(strings);
        switch (choose) {
            case 1:
                addAirLinePanel();
            case 2:
                increaseAmountCustomer();
            case 3:
                return;
        }

    }

    private void increaseAmountCustomer() throws Exception {
        Long chooseId = chooseCustomer();
        System.out.println("Do you want Cash?");
        String[] checkStr = new String[]{"Yes", "No"};
        int chooseCheck = new Input().chooseOption(checkStr);

        WalletChangeDTO wct = new WalletChangeDTO();
        wct.setCash(chooseCheck == 1);
        wct.setCustomerId(chooseId);
        Long amount = new Input("Enter your amount for increase :", Long.MAX_VALUE, 0L).getInputLong();
        wct.setAmount(amount);
        Boolean increaseWalletAmount = ApplicationContext.getCustomerService().
                isIncreaseWalletAmount(wct, SecurityContext.getActiveUser().getUserType());
        if (increaseWalletAmount)
            System.out.println("Increase amount of customer is successfully...");
        else
            System.out.println("Accessed Denied...");

    }

    private Long chooseCustomer() {
        List<Customer> customers = ApplicationContext.getCustomerService().findAll();
        customerViewList(customers);

        return new Input("enter id of customer you wanna increase amount of wallet :", Long.MAX_VALUE, 0L).getInputLong();

    }


    private void customerViewList(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(
                    "ID : " + customer.getId() + "\n" +
                            "First Name : " + customer.getFirst_name() + "\n" +
                            "Last Name : " + customer.getLast_name() + "\n" +
                            "National Code : " + customer.getNational_code() + "\n" +
                            "Birthday : " + customer.getBirth_day() + "\n"
            );
        }
    }

    private void ticketViewList(List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            System.out.println(
                    "ID : " + ticket.getId() + "\n" +
                            "Airline Name :" + ticket.getAir_line().getName() + "\n" +
                            "From :" + ticket.getStart_point() + "\n" +
                            "To :" + ticket.getEnd_point() + "\n" +
                            "Price :" + ticket.getPrice_ticket() + "\n" +
                            "Valency :" + ticket.getValency() + "\n" +
                            "\uD83D\uDEEB " + ticket.getTake_off_time() + "\n" +
                            "\uD83D\uDEEC " + ticket.getLanding_time() + "\n"
            );
        }
    }

    private void addAirLinePanel() {
        ApplicationContext.getAirLineService().save(
                new AirLine(
                        new Input("Enter name airline :").getInputString(),
                        new Input("Enter phone number for concat airline :").getInputString(),
                        getInformationCustomer()
                )
        );
    }

    private AirLineOperator getInformationCustomer() {
        return new
                AirLineOperator(
                InputInformation.getFirstName(),
                InputInformation.getLastName(),
                InputInformation.getUsername(),
                InputInformation.getNationalCode(),
                InputInformation.getPassword(),
                InputInformation.getBirthDay(),
                UserType.AIRLINE_OPERATOR,
                true
        );

    }
}
