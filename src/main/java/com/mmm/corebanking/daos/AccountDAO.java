package com.mmm.corebanking.daos;

import com.mmm.corebanking.entites.Account;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountDAO {


    @Transactional
    Account save(Account account);

    Account findByAccountId(Long accountId);


    List<Account> findAll();

}
