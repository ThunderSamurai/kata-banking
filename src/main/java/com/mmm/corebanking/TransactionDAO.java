package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;

public interface TransactionDAO {


    /*
        Return the updated account
     */
    Transaction save(Transaction transaction);


    Transaction findById(long transactionId);

}
