package com.mmm.corebanking.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mmm.corebanking.daos.jpa.MonytaryAmountJpaConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date creationDate= Calendar.getInstance().getTime();

    @Column
    private String creationUser="MMM";

    @Column
    private Date lastupdateDate=Calendar.getInstance().getTime();


    @Column(name = "ACCOUNT_ID", unique = true, nullable = false)
    private  Long accountId;

    @Convert(converter=MonytaryAmountJpaConverter.class)
    @Column(name = "AMOUNT")
    private  MonetaryAmount amount;


    @ManyToMany(mappedBy="accounts",
            cascade = CascadeType.ALL )
    @JsonIgnore
    private List<Customer> customers;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaction> transactionList;



}
