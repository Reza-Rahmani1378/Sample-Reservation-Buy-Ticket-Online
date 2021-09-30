package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.ZonedDateTime;

@Entity
@Table(name = Ticket.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity<Long> {
    public static final String TABLE_NAME = "ticket_table";

    public static final String FROM = "FROM";
    public static final String TO = "TO";


    @Column(name = FROM)
    private String from;
    @Column(name = TO)
    private String to;

    @Column
    private Date depart_time;

    @Column
    private Date return_time;

    @Column
    private String take_off_time;

    @Column
    private String landing_time;

    @Column
    private Long price_ticket;



    @ManyToOne
    @JoinTable(name = "air_line_id")
    private AirLine air_line;

    @ManyToOne
    @JoinTable(name = "customer_id")
    private Customer customer;

}
