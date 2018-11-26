package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;

import javax.inject.Named;

@Named
public class TransactionDAOMock implements TransactionDAO {


    @Override
    public Account save(Account account, Transaction transaction) {
        return null;
    }

    @Override
    public Account findById(String accountId) {
        return null;
    }
}
