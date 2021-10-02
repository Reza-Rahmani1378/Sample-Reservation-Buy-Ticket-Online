package ir.maktab56.airline.domain;

import ir.maktab56.airline.domain.enumeration.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AirLineOperator extends User{

        @OneToOne
        private AirLine airLine;

    public AirLineOperator(String firstName ,
                    String lastName ,
                    String username ,
                    String national_code,
                    String password ,
                    Date birth_day ,
                    UserType userType,
                    boolean isAirLineOperator ) {
        super(firstName , lastName , username ,national_code , password , birth_day , userType , isAirLineOperator);

    }
}
