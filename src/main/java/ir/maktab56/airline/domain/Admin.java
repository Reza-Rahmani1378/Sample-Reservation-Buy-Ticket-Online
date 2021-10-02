package ir.maktab56.airline.domain;

import ir.maktab56.airline.domain.enumeration.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Date;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User{

    public Admin(String first_name , String last_name , String username , String national_code,
                 String password , Date birth_day , UserType userType , boolean airLineOperator) {
        super(first_name , last_name , username , national_code , password , birth_day ,userType ,  airLineOperator);
    }
}
