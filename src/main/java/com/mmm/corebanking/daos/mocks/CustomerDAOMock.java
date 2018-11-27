package com.mmm.corebanking.daos.mocks;


import com.mmm.corebanking.daos.CustomerDAO;
import com.mmm.corebanking.entites.Customer;
import com.mmm.corebanking.entites.CustomerTestFactory;
import org.springframework.context.annotation.Profile;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static com.mmm.corebanking.daos.AccountDaoProviders.MOCK_ACCOUNT_DAO;

@Named
@Profile(MOCK_ACCOUNT_DAO)
public class CustomerDAOMock implements CustomerDAO {
    @Override
    public Customer save(Customer customer) {
        return customer;
    }

    @Override
    public Customer findByCustomerId(Long customerId) {
        return CustomerTestFactory.create();
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>();
    }

}
