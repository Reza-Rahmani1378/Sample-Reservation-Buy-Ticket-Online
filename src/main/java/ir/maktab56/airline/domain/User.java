package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import ir.maktab56.airline.domain.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name =User.TABLE_NAME )
@Inheritance
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<Long> {
    public static final String TABLE_NAME = "user_table";

    public static final String USER_TYPE = "user_type";
    public static final String IS_BOSS = "is_boss";

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
    private ZonedDateTime birth_day;

    @Column(columnDefinition = "false")
    private boolean isBoss;

    @Column(name = USER_TYPE)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToOne
    @JoinColumn(name = "air_line_id")
    private AirLine air_line;

    public User(
            String first_name ,
            String last_name ,
            String username ,
            String national_code ,
            String password ,
            ZonedDateTime birth_day ,
            boolean isBoss,
            UserType userType){
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.national_code = national_code;
        this.password = password;
        this.birth_day = birth_day;
        this.isBoss = isBoss;
        this.userType = userType;
    }

}
