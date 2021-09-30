package ir.maktab56.airline.service;

import ir.maktab56.airline.base.service.BaseService;
import ir.maktab56.airline.domain.Ticket;
import ir.maktab56.airline.domain.dto.TicketDto;

import java.util.List;

public interface TicketService extends BaseService<Ticket, Long> {

    List<Ticket> searchByFromAndTo(TicketDto ticketDto);

    List<Ticket> sortByAirLineName(String name);

    List<Ticket> sortedByPrice(int choose);

}
