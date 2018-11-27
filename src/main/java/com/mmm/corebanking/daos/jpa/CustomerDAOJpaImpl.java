package com.mmm.corebanking.daos.jpa;

import com.mmm.corebanking.daos.CustomerDAO;
import com.mmm.corebanking.entites.Customer;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static com.mmm.corebanking.daos.AccountDaoProviders.ACCOUNT_DATABASE_DAO;

@Named
@Profile(ACCOUNT_DATABASE_DAO)
public class CustomerDAOJpaImpl implements CustomerDAO {

    private final CustomerRepository customerRepository;

    @Inject
    public CustomerDAOJpaImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByCustomerId(Long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
