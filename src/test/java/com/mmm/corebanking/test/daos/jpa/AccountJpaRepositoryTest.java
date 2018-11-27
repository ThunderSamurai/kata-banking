package com.mmm.corebanking.test.daos.jpa;

import com.mmm.corebanking.daos.jpa.AccountRepository;
import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.entites.AccountTestFactory;
import com.mmm.corebanking.utils.MoneyUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.money.MonetaryAmount;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountJpaRepositoryTest {

    @Inject
    AccountRepository accountRepository;

    private  Account accountExpected;

    @Before
    //GIVEN
    public void init(){
        accountExpected= accountRepository.save(AccountTestFactory.createAccount());
    }

    @Test
    public void should_find_an_account_by_account_id(){

        //WHEN
        Account resultAccount=accountRepository.findByAccountId(accountExpected.getAccountId());

        //THEN
        assertThat(resultAccount).isNotNull();
        assertThat(resultAccount).isEqualToComparingFieldByField(accountExpected);


    }


    @Test
    public void should_update_an_account_by_account_id(){

        //GIVEN
        Account resultAccount=accountRepository.findByAccountId(accountExpected.getAccountId());

        MonetaryAmount fstAmtEUR = MoneyUtils.createEuroMonetaryAmount(250);

        resultAccount.setAmount(fstAmtEUR);

        //WHEN
        Account updatedAccount=accountRepository.save(resultAccount);


        //THEN
        assertThat(updatedAccount).isNotNull();
        assertThat(updatedAccount).isEqualToComparingFieldByField(resultAccount);


    }

}
