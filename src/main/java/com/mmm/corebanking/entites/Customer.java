package com.mmm.corebanking.entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer implements Serializable {


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


    @Column(name = "CUSTOMER_ID", unique = true, nullable = false)
    private Long customerId;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobileNumber;

    @ManyToMany
    @JoinTable(
            name="CUSTOMER_ACCOUNTS",
            joinColumns=@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID"),
            inverseJoinColumns=@JoinColumn(name="ACCOUNT_ID", referencedColumnName="ACCOUNT_ID"))
    private Set<Account> accounts = new HashSet<>();
}
