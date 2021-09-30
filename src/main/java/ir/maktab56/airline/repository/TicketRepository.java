package ir.maktab56.airline.repository;

import ir.maktab56.airline.base.repository.BaseRepository;
import ir.maktab56.airline.domain.Ticket;
import ir.maktab56.airline.domain.dto.TicketDto;

import java.util.List;

public interface TicketRepository extends BaseRepository<Ticket, Long> {


    List<Ticket> searchByFromAndTo(TicketDto ticketDto);

    List<Ticket> sortByAirLineName(String name);

    List<Ticket> sortedByPrice(int choose);
}
