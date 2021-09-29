package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Wallet.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet extends BaseEntity<Long> {
    public static final String TABLE_NAME = "wallet_table";
    @OneToOne
    @JoinTable(name = "user_id")
    private User user;

    private Long totalAmount = 0L;

    private Long creditAmount = 0L;

    private Long cashAmount = 0L;

}

