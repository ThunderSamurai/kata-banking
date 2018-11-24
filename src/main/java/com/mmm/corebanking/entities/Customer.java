package com.mmm.corebanking.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @Column(name="ID")
    private Long customerId;

    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobilenumber;

    @ManyToMany
    @JoinTable(
            name="CUSTOMER_ACCOUNTS",
            joinColumns=@JoinColumn(name="EMP_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="PROJ_ID", referencedColumnName="ID"))
    private Set<Account> accounts = new HashSet<>();
}
