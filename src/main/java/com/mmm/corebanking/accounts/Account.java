package com.mmm.corebanking.accounts;

import com.mmm.corebanking.shared.entities.AbstractTrackedEntity;
import com.mmm.corebanking.cutomers.Customer;
import com.mmm.corebanking.accounts.transactions.Transaction;
import lombok.Builder;
import lombok.Data;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
public class Account extends AbstractTrackedEntity {

    @Id
    @Column(name="ID")
    private final long accountId;

    private  MonetaryAmount amount;


    //TODO : optimiser
    @ManyToMany(mappedBy="accounts")
    private Set<Customer> customers;

    @OneToMany(mappedBy="account")
    private Set<Transaction> transactionList;
    //Others infos like 'creation date', 'last save date', ....


}
