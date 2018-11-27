package com.mmm.corebanking.services;

import com.mmm.corebanking.entites.Account;

import java.util.List;

public interface AccountService {


    /*
        Return the updated account
     */
    Account save(Account account);


    Account findByAccountId(Long accountId);

    List<Account> findAll();

}
