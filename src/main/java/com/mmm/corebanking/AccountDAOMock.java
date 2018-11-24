package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;

import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class AccountDAOMock implements AccountDAO {


    @Override
    public Account update(long accountId, BigDecimal amount) {
        return null;
    }
}
