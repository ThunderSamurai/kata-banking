package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Currency;

@Named
public class AccountDAOMock implements AccountDAO {


    @Override
    public Account save(Account account, Transaction transaction) {
        return null;
    }

    @Override
    public Account findById(String accountId) {
        return null;
    }
}
