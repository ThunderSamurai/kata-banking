package com.mmm.corebanking.accounts.dao;

import com.mmm.corebanking.accounts.Account;

public interface AccountDAO {


    /*
        Return the updated account
     */
    Account save(Account account);

    Account findById(long accountId);

}
