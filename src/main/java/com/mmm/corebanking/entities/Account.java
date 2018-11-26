package com.mmm.corebanking.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
public class Account {

    @Id
    @Column(name="ID")
    private final long accountId;

    private final BigDecimal amount;

    private final Currency currency;

    //TODO : optimiser
    @ManyToMany(mappedBy="accounts")
    Set<Customer> customers;

    @OneToMany(mappedBy="account")
    private Set<Transaction> transactionList;
    //Others infos like 'creation date', 'last save date', ....

}