package com.mmm.corebanking.accounts;

public interface AccountService {


    /*
        Return the updated account
     */
    Account save(Account account);


    Account findById(long accountId);

}
