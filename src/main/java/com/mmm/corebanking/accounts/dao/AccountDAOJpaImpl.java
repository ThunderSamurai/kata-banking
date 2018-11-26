package com.mmm.corebanking.accounts.dao;

import com.mmm.corebanking.accounts.Account;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;

import static com.mmm.corebanking.shared.entities.MockProfiles.ACCOUNT_DATABASE_DAO;

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
    public Account findById(long accountId) {
        return accountRepository.findById(Long.valueOf(accountId)).get();
    }
}
