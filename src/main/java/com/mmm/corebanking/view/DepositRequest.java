package com.mmm.corebanking.view;

import com.mmm.corebanking.accounts.Account;
import com.mmm.corebanking.accounts.transactions.Transaction;
import com.mmm.corebanking.accounts.transactions.TransactionType;
import lombok.Builder;
import lombok.Data;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import static com.mmm.corebanking.accounts.transactions.TransactionType.DEPOSIT;
import static com.mmm.corebanking.accounts.transactions.TransactionType.WITHDRAWL;

@Data
@Builder
public class DepositRequest {

    // TODO : Utilisation de la currency
    // TODO : Les centimes ?

    private final long amount;
    private final String accountId;

    private final int transactionType;
    private final String currency;

    public Transaction toTransaction(){
        Monetary.getDefaultAmountFactory().setCurrency("EUR");

        CurrencyUnit eur = Monetary.getCurrency(this.currency);
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(this.amount).create();

        TransactionType transactionType=(DEPOSIT.ordinal()==this.transactionType)? DEPOSIT: WITHDRAWL;

        return Transaction.builder().account(Account.builder().accountId(Long.valueOf(this.accountId)).build()).transactionType(transactionType).monetaryAmount(fstAmtEUR).build();

    }
}
