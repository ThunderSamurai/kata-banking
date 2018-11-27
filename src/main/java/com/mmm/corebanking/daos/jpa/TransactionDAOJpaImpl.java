package com.mmm.corebanking.daos.jpa;

import com.mmm.corebanking.daos.TransactionDAO;
import com.mmm.corebanking.entites.Transaction;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static com.mmm.corebanking.daos.AccountDaoProviders.ACCOUNT_DATABASE_DAO;

@Named
@Profile(ACCOUNT_DATABASE_DAO)
public class TransactionDAOJpaImpl implements TransactionDAO {

    private final TransactionRepository transactionRepository;

    @Inject
    public TransactionDAOJpaImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction findByTransactionId(Long transactionId) {
        return transactionRepository.findByTransactionId(transactionId);
    }

    @Override
    public List<Transaction> findAll() {


        return transactionRepository.findAll();
    }
}
