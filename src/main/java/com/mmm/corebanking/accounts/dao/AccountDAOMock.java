package com.mmm.corebanking.accounts.dao;

import com.mmm.corebanking.accounts.Account;
import org.springframework.context.annotation.Profile;

import javax.inject.Named;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import static com.mmm.corebanking.shared.entities.MockProfiles.MOCK_ACCOUNT_DAO;

@Named
@Profile(MOCK_ACCOUNT_DAO)
public class AccountDAOMock implements AccountDAO {


    @Override
    public Account save(Account account) {
        return account;
    }

    @Override
    public Account findById(long accountId) {
        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(200).create();

        return Account.builder().accountId(accountId).amount(fstAmtEUR).build();

    }
}
