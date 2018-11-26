package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;

public interface TransactionService {


    /*
        Return the updated account
     */
    Transaction save(Transaction account);


    Transaction findById(String transactionId);

}
