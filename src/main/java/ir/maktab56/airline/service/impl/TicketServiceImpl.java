package ir.maktab56.airline.service.impl;


import ir.maktab56.airline.base.service.impl.BaseServiceImpl;
import ir.maktab56.airline.domain.Ticket;
import ir.maktab56.airline.domain.dto.TicketDto;
import ir.maktab56.airline.repository.TicketRepository;
import ir.maktab56.airline.service.TicketService;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository>
    implements TicketService{


    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public List<Ticket> searchByFromAndTo(TicketDto ticketDto) {
        return repository.searchByFromAndTo(ticketDto);
    }

    @Override
    public List<Ticket> sortByAirLineName(String name) {
        return repository.sortByAirLineName(name);
    }

    @Override
    public List<Ticket> sortedByPrice(int choose) {
        return repository.sortedByPrice(choose);
    }
}
