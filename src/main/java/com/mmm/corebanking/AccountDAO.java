package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;

import java.math.BigDecimal;
import java.util.Currency;

public interface AccountDAO {


    /*
        Return the updated account
     */
    Account save(Account account);

    Account findById(String accountId);

}
