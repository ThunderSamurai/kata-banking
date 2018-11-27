package com.mmm.corebanking.daos.mocks;

import com.mmm.corebanking.daos.TransactionDAO;
import com.mmm.corebanking.entites.AccountTestFactory;
import com.mmm.corebanking.entites.Transaction;
import com.mmm.corebanking.entites.TransactionTestFactory;
import com.mmm.corebanking.entites.TransactionType;
import org.springframework.context.annotation.Profile;

import javax.inject.Named;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.List;

import static com.mmm.corebanking.daos.AccountDaoProviders.MOCK_ACCOUNT_DAO;

@Named
@Profile(MOCK_ACCOUNT_DAO)
public class TransactionDAOMock implements TransactionDAO {


    @Override
    public Transaction save(Transaction transaction) {
        return transaction;
    }

    @Override
    public Transaction findByTransactionId(Long transactionId) {
        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(201).create();

        return  Transaction.builder().transactionId(transactionId).transactionType(TransactionType.DEPOSIT).monetaryAmount(fstAmtEUR).build();
    }

    @Override
    public List<Transaction> findAll() {
        return TransactionTestFactory.createTransactionListWithSameAmount(10, 1L,AccountTestFactory.createAccount());
    }
}
