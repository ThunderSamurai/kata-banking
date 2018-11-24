package com.mmm.corebanking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;

@Entity
public class Account {

    @Id
    @Column(name="ID")
    Long accounntId;

    BigDecimal amount;

    Currency currency;

    //TODO : optimiser
    @ManyToMany(mappedBy="accounts")
    Set<Customer> customers;

    //Others infos like 'creation date', 'last update date', ....

}
