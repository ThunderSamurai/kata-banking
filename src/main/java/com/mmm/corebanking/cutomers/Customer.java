package com.mmm.corebanking.cutomers;

import com.mmm.corebanking.accounts.Account;
import com.mmm.corebanking.shared.entities.AbstractTrackedEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
public class Customer extends AbstractTrackedEntity {

    @Id
    @Column(name="ID")
    private long customerId;

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
