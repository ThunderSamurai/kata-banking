package com.mmm.corebanking.accounts.transactions;

import com.mmm.corebanking.accounts.AccountTestFactory;

import javax.inject.Named;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.Date;
import java.util.Set;

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

    @Override
    public Set<Transaction> getTransactionsByDate(Date startingDate, Date endingDate) {
        return TransactionTestFactory.createTransactionListWithSameAmount(10, AccountTestFactory.createAccount());
    }
}
