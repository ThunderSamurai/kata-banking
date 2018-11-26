package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;

public interface TransactionDAO {


    /*
        Return the updated account
     */
    Account save(Account account, Transaction transaction);


    Account findById(String accountId);

}
