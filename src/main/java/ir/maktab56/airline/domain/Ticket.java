package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = Ticket.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Ticket extends BaseEntity<Long> {
    public static final String TABLE_NAME = "ticket_table";

   /* public static final String FROM = "FROM";
    public static final String TO = "TO";*/

    @Column(length = 30)
    private String start_point;
    @Column(length = 30)
    private String end_point;

    @Column
    private String depart_time;
//
    @Column
    private String return_time;

    @Column(length = 30)
    private String take_off_time;
//
    @Column(length = 30)
    private String landing_time;
//
    @Column
    private Long price_ticket;

    @Column
    private Long valency;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "air_line_id")
    private AirLine air_line;



    public Ticket(String start_point, String end_point, String depart_time, String take_off_time, String landing_time, Long price_ticket) {
        this.start_point = start_point;
        this.end_point = end_point;
        this.depart_time = depart_time;
        this.price_ticket = price_ticket;
    }


}
