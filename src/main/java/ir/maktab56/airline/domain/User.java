package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import ir.maktab56.airline.domain.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.ZonedDateTime;
@Entity
@Table(name =User.TABLE_NAME )
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<Long> {
    public static final String TABLE_NAME = "user_table";

    public static final String USER_TYPE = "user_type";

    private static final String AIR_LINE_OPERATOR = "air_line_operator";


    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = false ,unique = true)
    private String username;

    @Column(nullable = false , unique = true)
    private String national_code;

    @Column
    private String password;

    @Column
    private Date birth_day;




    @Column(name = USER_TYPE)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = AIR_LINE_OPERATOR , columnDefinition = "TINYINT(1) default 0")
    private boolean airLineOperator;

}
