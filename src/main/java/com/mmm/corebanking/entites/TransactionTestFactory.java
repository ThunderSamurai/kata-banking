package com.mmm.corebanking.entites;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionTestFactory {

    private final static Random RANDOM_1 = new Random();
    private final static Random RANDOM_2 = new Random();
    private final static Random RANDOM_3 = new Random();

    public static Transaction createDepositTransaction(long amount,long customerId, Account account){

        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(amount).create();

       return Transaction.builder().creationCustomerId(customerId).transactionId(1L).transactionType(TransactionType.DEPOSIT).monetaryAmount(fstAmtEUR).account(account).build();



    }

    public static Transaction createWithdrawalTransaction(long amount, long customerId, Account account){

        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(amount).create();

        return Transaction.builder().creationCustomerId(customerId).transactionId(1L).transactionType(TransactionType.WITHDRAWL).monetaryAmount(fstAmtEUR).account(account).build();



    }


    public static List<Transaction> createTransactionListWithSameAmount(long amount,long customerId, Account account){

        List<Transaction> transactions=new ArrayList<>();
        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(amount).create();

       transactions.add(Transaction.builder().creationCustomerId(customerId).id(RANDOM_1.nextLong()).transactionId(RANDOM_1.nextLong()).transactionType(TransactionType.WITHDRAWL).monetaryAmount(fstAmtEUR).account(account).build());

       transactions.add(Transaction.builder().creationCustomerId(customerId).id(RANDOM_2.nextLong()).transactionId(RANDOM_2.nextLong()).transactionType(TransactionType.DEPOSIT).monetaryAmount(fstAmtEUR).account(account).build());

       transactions.add(Transaction.builder().creationCustomerId(customerId).id(RANDOM_3.nextLong()).transactionId(RANDOM_3.nextLong()).transactionType(TransactionType.DEPOSIT).monetaryAmount(fstAmtEUR).account(account).build());

       return transactions;

    }
}
