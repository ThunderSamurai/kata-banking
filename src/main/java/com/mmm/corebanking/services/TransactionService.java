package com.mmm.corebanking.services;

import com.mmm.corebanking.entites.Transaction;

import java.util.List;

public interface TransactionService {


    /*
        Return the updated account
     */
    Transaction save(Transaction account);


    Transaction findByTransactionId(Long transactionId);

    List<Transaction> findAll();

}
