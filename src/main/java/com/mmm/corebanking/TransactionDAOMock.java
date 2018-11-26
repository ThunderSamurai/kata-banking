package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;
import com.mmm.corebanking.entities.TransactionType;

import javax.inject.Named;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import java.math.BigDecimal;
import java.util.Currency;

@Named
public class TransactionDAOMock implements TransactionDAO {


    @Override
    public Transaction save(Transaction transaction) {
        return transaction;
    }

    @Override
    public Transaction findById(long transactionId) {

        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(201).create();

        return  Transaction.builder().transactionId(transactionId).transactionType(TransactionType.DEPOSIT).monetaryAmount(fstAmtEUR).build();
    }
}
