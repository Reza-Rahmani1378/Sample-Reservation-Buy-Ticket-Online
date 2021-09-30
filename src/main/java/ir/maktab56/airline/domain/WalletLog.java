package ir.maktab56.airline.domain;

import ir.maktab56.airline.base.domain.BaseEntity;
import ir.maktab56.airline.domain.enumeration.WalletType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = WalletLog.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletLog extends BaseEntity<Long> {
    public static final String TABLE_NAME = "wallet_log_table";

    @Column
    private LocalDateTime createDate;

    @Column
    private WalletType logType;

    @Column
    private String uniqueCode;

    @Column
    private String userType;

    @Column
    private Long amount;

    @Column
    private Long totalAmount;

    @Column
    private Long creditAmount;

    @Column
    private Long cashAmount;

    @Column
    private Long creditAmountChange;

    @Column
    private Long cashAmountChange;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
