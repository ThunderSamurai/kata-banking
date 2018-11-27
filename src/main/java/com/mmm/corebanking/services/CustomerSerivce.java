package com.mmm.corebanking.services;

import com.mmm.corebanking.entites.Customer;

public interface CustomerSerivce {

    /*
      Return the updated customer
   */
    Customer save(Customer account);


    Customer findByCustomerId(Long customerId);
}
