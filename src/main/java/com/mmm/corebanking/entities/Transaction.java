package com.mmm.corebanking.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Data
@RequiredArgsConstructor
public class Transaction {


    @Id
    @Column(name="ID")
    private final long transactionId;

    private final TransactionType transactionType;

    private final BigDecimal amount;

    private final Currency currency;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;
}
