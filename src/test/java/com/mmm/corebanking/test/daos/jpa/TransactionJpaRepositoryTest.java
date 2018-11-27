package com.mmm.corebanking.test.daos.jpa;

import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.entites.AccountTestFactory;
import com.mmm.corebanking.daos.jpa.AccountRepository;
import com.mmm.corebanking.entites.Transaction;
import com.mmm.corebanking.entites.TransactionTestFactory;
import com.mmm.corebanking.daos.jpa.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionJpaRepositoryTest {

    @Inject
    TransactionRepository transactionRepository;

    @Inject
    AccountRepository accountRepository;

    private Transaction transactionExpected;

    @Before
    public void init(){

       Account accountExppected=accountRepository.save(AccountTestFactory.createAccount());
       transactionExpected= transactionRepository.saveAll(TransactionTestFactory.createTransactionListWithSameAmount(10,1,accountExppected)).get(0);

    }

    @Test
    public void should_find_an_transaction_by_account(){

        List<Transaction> transactionResult=transactionRepository.findByAccount(transactionExpected.getAccount());

        assertThat(transactionResult).isNotNull();
        assertThat(transactionResult).isNotEmpty();

    }

    @Test
    public void should_find_an_transaction_by_transactionid(){

        Transaction transactionResult=transactionRepository.findByTransactionId(transactionExpected.getTransactionId());

        assertThat(transactionResult).isNotNull();
        assertThat(transactionResult).isEqualToComparingFieldByField(transactionExpected);

    }

}
