package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import ir.maktab56.airline.domain.enumeration.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends User{

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToOne(mappedBy = "customer" , cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToOne
    @JoinColumn(name = "air_line_id")
    private AirLine air_line;

    public Customer(String firstName ,
                    String lastName ,
                    String username ,
                    String national_code,
                    String password ,
                    ZonedDateTime birth_day ,
                    UserType userType,
                    boolean isAirLineOperator ) {
      super(firstName , lastName , username ,national_code , password , birth_day , userType , isAirLineOperator );
    }

}
