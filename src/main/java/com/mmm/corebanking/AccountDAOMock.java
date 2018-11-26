package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;

import javax.inject.Named;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.util.Currency;

@Named
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
