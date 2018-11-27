package com.mmm.corebanking.services;

import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.daos.AccountDAO;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class AccountServiceImpl implements AccountService {



    private final AccountDAO accountDAO;

    @Inject
    public AccountServiceImpl(AccountDAO accountDAO){

        this.accountDAO=accountDAO;

    }


    @Override
    public Account save(Account account) {
        return this.accountDAO.save(account);
    }

    @Override
    public Account findByAccountId(Long accountId) {
        return this.accountDAO.findByAccountId(accountId);
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

}
