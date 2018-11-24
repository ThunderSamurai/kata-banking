package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;

import java.math.BigDecimal;

public interface AccountDAO {


    /*
    return the updated account
     */
    Account update(long accountId, BigDecimal amount);

}
