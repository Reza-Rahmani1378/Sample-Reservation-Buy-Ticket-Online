package ir.maktab56.airline.domain;

import ir.maktab56.airline.domain.enumeration.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends User{

    public Customer(String first_name , String last_name , String username , String national_code,
                    String password , Date birth_day , UserType userType , boolean airLinOperator) {
        super(first_name , last_name , username , national_code , password,
                birth_day , userType , airLinOperator);
    }

  /*  @OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL)
    private List<Ticket> tickets;*/

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(name = "customer_ticket_join_table",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    )
    Set<Ticket> Tickets = new HashSet<>();

    @OneToOne(mappedBy = "customer" ,cascade = CascadeType.ALL)
    private Wallet wallet;



}
