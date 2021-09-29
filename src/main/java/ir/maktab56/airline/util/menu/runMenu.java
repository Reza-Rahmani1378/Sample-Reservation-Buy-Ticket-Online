package ir.maktab56.airline.util.menu;

import ir.maktab56.airline.domain.AirLine;
import ir.maktab56.airline.domain.Ticket;
import ir.maktab56.airline.domain.User;
import ir.maktab56.airline.domain.dto.TicketDto;
import ir.maktab56.airline.domain.enumeration.UserType;
import ir.maktab56.airline.util.ApplicationContext;
import ir.maktab56.airline.util.SecurityContext;
import ir.maktab56.airline.util.input.Input;
import ir.maktab56.airline.util.input.InputInformation;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class runMenu extends Menu {

    public runMenu() {
        super(new String[]{"Login", "Sign Up", "Airline Company Panel", "Exit"});
    }


    public void run() {
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
                            case USER -> {
                                User normalUser =
                                        ApplicationContext.getUserService().findById(activeUser.getId());
                                normalUserMenu(normalUser);

                            }

                        }
                    }

                    break;
                case 2:
                    ApplicationContext.getUserService().singUp();
                    break;

                case 3:

                    break;
                case 4:
                    return;

            }
        }
    }

    private void normalUserMenu(User normalUser) {
        String[] strings = new String[] {
                "One way" ,"Return" , "log out"
        };
        int choose = new Input().chooseOption(strings);
        switch (choose) {
            case 1:
               List<Ticket> tickets =  search();
                filtering(tickets);

        }
    }

    private void filtering(List<Ticket> tickets) {
        String[] strings = new String[] {
                "Filter By Max Price" ,"Filter By Min Price","Airline name", "Previous Menu"
        };
        int choose = new Input().chooseOption(strings);
        switch (choose) {
            case 1:
                List<Ticket> sortedTicketsByMaxPrice =
                        tickets.stream()
                                .sorted(Comparator.comparingDouble(Ticket::getPrice_ticket))
                                .collect(Collectors.toList());
                sortedTicketsByMaxPrice.forEach(System.out::println);
                break;
            case 2:
               List<Ticket> sortedTicketsByMinPrice =
                       tickets.stream()
                               .sorted(Comparator.comparingDouble(Ticket::getPrice_ticket).reversed())
                               .collect(Collectors.toList());
               sortedTicketsByMinPrice.forEach(System.out::println);
            case 3:
              /*  String name = new Input("Enter name Airline :").getInputString();
                List<String> nameListAirLine = new ArrayList<>();
                for (Ticket ticket : tickets) {
                    nameListAirLine.add(ticket.getAir_line().getName());
                }
                List<String> names = nameListAirLine.stream().filter(word -> word.equals(name)).collect(Collectors.toList());*/
                String name = new Input("Enter name Airline :").getInputString();
                List<Ticket> sortByAirLineName = ApplicationContext.getTicketService().sortByAirLineName(name);
                if (sortByAirLineName == null)
                    System.out.println("This airline is not exist.");
                assert sortByAirLineName != null;
                sortByAirLineName.forEach(System.out::println);
                break;
            case 4:
                return;

        }
    }

    private List<Ticket> search() {
        String from = new Input("Enter FROM :").getInputString();
        String to = new Input("Enter TO :").getInputString();
        TicketDto ticketDto = new TicketDto(from , to);
        List<Ticket> tickets = ApplicationContext.getTicketService().searchByFromAndTo(ticketDto);
        tickets.forEach(System.out::println);
        return tickets;
    }

    private void adminMenu() {
        String[] strings = new String[]{
                "Add Airline Panel", "Log out"
        };
        int choose = new Input().chooseOption(strings);
        switch (choose) {
            case 1:
                addAirLinePanel();
            case 2:
                return;
        }

    }

    private void addAirLinePanel() {
        ApplicationContext.getAirLineService().save(
                new AirLine(
                        new Input("Enter name airline :").getInputString(),
                        new Input("Enter phone number for concat airline :").getInputString(),
                        getInformationUser()
                )
        );
    }

    private User getInformationUser() {
        return new
                User(
                InputInformation.getFirstName(),
                InputInformation.getLastName(),
                InputInformation.getUsername(),
                InputInformation.getNationalCode(),
                InputInformation.getPassword(),
                InputInformation.getBirthDay(),
                true,
                UserType.USER
                );
    }
}
