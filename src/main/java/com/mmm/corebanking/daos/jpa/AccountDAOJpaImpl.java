package com.mmm.corebanking.daos.jpa;

import com.mmm.corebanking.daos.AccountDAO;
import com.mmm.corebanking.entites.Account;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

import static com.mmm.corebanking.daos.AccountDaoProviders.ACCOUNT_DATABASE_DAO;

@Named
@Profile(ACCOUNT_DATABASE_DAO)
public class AccountDAOJpaImpl implements AccountDAO {

    private final AccountRepository accountRepository;

    @Inject
    public AccountDAOJpaImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findByAccountId(Long accountId) {
        return accountRepository.findByAccountId(accountId);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

}
