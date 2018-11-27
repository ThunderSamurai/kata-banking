package com.mmm.corebanking.daos;

import com.mmm.corebanking.entites.Transaction;

import javax.transaction.Transactional;
import java.util.List;


public interface TransactionDAO {

    @Transactional
    Transaction save(Transaction transaction);

    Transaction findByTransactionId(Long transactionId);

    List<Transaction>  findAll();
}
