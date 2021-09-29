package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = Ticket.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity<Long> implements Comparable<Ticket> {
    public static final String TABLE_NAME = "ticket_table";

    public static final String FROM = "FROM";
    public static final String TO = "TO";


    @Column(name = FROM)
    private String from;
    @Column(name = TO)
    private String to;

    @Column
    private ZonedDateTime depart_time;

    @Column
    private ZonedDateTime return_time;

    @Column
    private Double price_ticket;



    @ManyToOne
    @JoinTable(name = "air_line_id")
    private AirLine air_line;

    @ManyToOne
    @JoinTable(name = "user_id")
    private User user;



    @Override
    public int compareTo(Ticket ticket) {
        if (ticket.price_ticket == price_ticket)
            return ticket.getId().compareTo(getId());
        else if (ticket.price_ticket > price_ticket)
            return 1;
        else
            return -1;
    }
}
   /* Comparator<ir.maktab56.airline.util.test.User> customComparator= new Comparator<ir.maktab56.airline.util.test.User>() {
        @Override
        public int compare(ir.maktab56.airline.util.test.User o1, ir.maktab56.airline.util.test.User o2) {
            if (o1.getPrice() == o2.getPrice())
                return o1.getName().compareTo(o2.getName());
            else if (o1.getPrice() > o2.getPrice())
                return 1;
            else
                return -1;
        }
    };*/