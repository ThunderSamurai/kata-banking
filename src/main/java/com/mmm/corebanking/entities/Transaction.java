package com.mmm.corebanking.entities;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.money.MonetaryAmount;
import javax.persistence.*;

@Entity
@Data
@Builder
public class Transaction {


    @Id
    @Column(name="ID")
    private final long transactionId;

    private final TransactionType transactionType;

    private final MonetaryAmount monetaryAmount;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;
}
