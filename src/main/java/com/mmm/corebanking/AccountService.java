package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;

public interface AccountService {


    /*
        Return the updated account
     */
    Account save(Account account);


    Account findById(String accountId);

}
