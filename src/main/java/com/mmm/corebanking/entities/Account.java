package com.mmm.corebanking.entities;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;

@Entity
@Data
@Builder
public class Account {

    @Id
    @Column(name="ID")
    private final long accountId;

    private final MonetaryAmount amount;


    //TODO : optimiser
    @ManyToMany(mappedBy="accounts")
    private Set<Customer> customers;

    @OneToMany(mappedBy="account")
    private Set<Transaction> transactionList;
    //Others infos like 'creation date', 'last save date', ....

}
