package com.mmm.corebanking.accounts;

import com.mmm.corebanking.accounts.dao.AccountDAO;

import javax.inject.Inject;
import javax.inject.Named;

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
    public Account findById(long accountId) {
        return this.accountDAO.findById(accountId);
    }
}
