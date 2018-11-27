package com.mmm.corebanking.test.daos.jpa;

import com.mmm.corebanking.daos.jpa.CustomerRepository;
import com.mmm.corebanking.entites.Customer;
import com.mmm.corebanking.entites.CustomerTestFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerJpaRepositoryTest {

    @Inject
    CustomerRepository customerRepository;

    private Customer customerExpected;

    @Before
    //GIVEN
    public void init(){
        customerExpected = customerRepository.save(CustomerTestFactory.create());
    }

    @Test
    public void should_find_an_account_by_account_id(){

        //WHEN
        Customer customerResult=customerRepository.findByCustomerId(customerExpected.getCustomerId());

        //THEN
        assertThat(customerResult).isNotNull();
        assertThat(customerResult).isEqualToComparingFieldByField(customerExpected);


    }


}
