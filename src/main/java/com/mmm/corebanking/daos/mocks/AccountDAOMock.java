package com.mmm.corebanking.daos.mocks;

import com.mmm.corebanking.daos.AccountDAO;
import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.utils.MoneyUtils;
import org.springframework.context.annotation.Profile;

import javax.inject.Named;
import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.List;

import static com.mmm.corebanking.daos.AccountDaoProviders.MOCK_ACCOUNT_DAO;

@Named
@Profile(MOCK_ACCOUNT_DAO)
public class AccountDAOMock implements AccountDAO {


    @Override
    public Account save(Account account) {
        return account;
    }

    @Override
    public Account findByAccountId(Long accountId) {

        MonetaryAmount fstAmtEUR = MoneyUtils.createEuroMonetaryAmount(200);

        return Account.builder().accountId(accountId).amount(fstAmtEUR).build();
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>();
    }

}
