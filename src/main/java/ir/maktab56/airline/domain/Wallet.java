package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = Wallet.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet extends BaseEntity<Long> {
    public static final String TABLE_NAME = "wallet_table";
    @OneToOne
    @JoinTable(name = "customer_id")
    private Customer customer;

    @Column
    private Long totalAmount = 0L;

    @Column
    private Long creditAmount = 0L;

    @Column
    private Long cashAmount = 0L;

}

