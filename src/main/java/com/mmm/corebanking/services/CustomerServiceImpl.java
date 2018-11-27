package com.mmm.corebanking.services;

import com.mmm.corebanking.daos.CustomerDAO;
import com.mmm.corebanking.entites.Customer;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerServiceImpl implements CustomerSerivce {

    private final CustomerDAO customerDAO;

    @Inject
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public Customer findByCustomerId(Long customerId) {
        return customerDAO.findByCustomerId(customerId);
    }
}
