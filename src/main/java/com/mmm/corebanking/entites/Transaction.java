package com.mmm.corebanking.entites;

import com.mmm.corebanking.daos.jpa.MonytaryAmountJpaConverter;
import com.mmm.corebanking.daos.jpa.TransactionTypeJpaConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date creationDate= Calendar.getInstance().getTime();

    @Column(name = "CREATION_CUSTOMER_ID", nullable = false)
    private Long creationCustomerId;

    @Column
    private Date lastupdateDate=Calendar.getInstance().getTime();

    @Column(name = "TRANSACTION_ID", unique = true, nullable = false)
    private Long transactionId;

    @Column
    @Convert(converter= TransactionTypeJpaConverter.class)
    private  TransactionType transactionType;

    @Column
    @Convert(converter= MonytaryAmountJpaConverter.class)
    private  MonetaryAmount monetaryAmount;


    @ManyToOne(fetch=FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;
}
