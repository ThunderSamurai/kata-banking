package com.mmm.corebanking.daos.jpa;

import com.mmm.corebanking.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByCustomerId(Long customerId);
}
