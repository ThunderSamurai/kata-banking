package com.mmm.corebanking.accounts.transactions;

import com.mmm.corebanking.accounts.Account;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.HashSet;
import java.util.Set;

public class TransactionTestFactory {

    public static Transaction createDepositTransaction(long amount, Account account){

        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(amount).create();

       return Transaction.builder().transactionId(1).transactionType(TransactionType.DEPOSIT).monetaryAmount(fstAmtEUR).account(account).build();



    }

    public static Transaction createWithdrawalTransaction(long amount, Account account){

        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(amount).create();

        return Transaction.builder().transactionId(1).transactionType(TransactionType.WITHDRAWL).monetaryAmount(fstAmtEUR).account(account).build();



    }


    public static Set<Transaction> createTransactionListWithSameAmount(long amount, Account account){

        Set<Transaction> transactions=new HashSet<>();
        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(amount).create();

       transactions.add(Transaction.builder().transactionId(1).transactionType(TransactionType.WITHDRAWL).monetaryAmount(fstAmtEUR).account(account).build());

       transactions.add(Transaction.builder().transactionId(2).transactionType(TransactionType.DEPOSIT).monetaryAmount(fstAmtEUR).account(account).build());

       transactions.add(Transaction.builder().transactionId(3).transactionType(TransactionType.DEPOSIT).monetaryAmount(fstAmtEUR).account(account).build());

       return transactions;

    }
}
