package com.mmm.corebanking.daos;

import com.mmm.corebanking.entites.Customer;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerDAO {

    @Transactional
    Customer save(Customer customer);

    Customer findByCustomerId(Long customerId);

    List<Customer> findAll();
}
