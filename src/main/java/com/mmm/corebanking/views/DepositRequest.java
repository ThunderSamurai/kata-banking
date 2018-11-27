package com.mmm.corebanking.views;

import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.entites.Transaction;
import com.mmm.corebanking.entites.TransactionType;
import lombok.Builder;
import lombok.Data;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import static com.mmm.corebanking.entites.TransactionType.DEPOSIT;
import static com.mmm.corebanking.entites.TransactionType.WITHDRAWL;

@Data
@Builder
public class DepositRequest {

    // TODO : Utilisation de la currency
    // TODO : Les centimes ?

    private final long amount;
    private final String accountId;
    private final String transactionId;
    private final String customerId;

    private final int transactionType;
    private final String currency;

    public Transaction toTransaction(){
        Monetary.getDefaultAmountFactory().setCurrency("EUR");

        CurrencyUnit eur = Monetary.getCurrency(this.currency);
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(this.amount).create();

        TransactionType transactionType=(DEPOSIT.ordinal()==this.transactionType)? DEPOSIT: WITHDRAWL;

        return Transaction.builder().creationCustomerId(Long.valueOf(customerId)).transactionId(Long.valueOf(transactionId)).account(Account.builder().accountId(Long.valueOf(this.accountId)).build()).transactionType(transactionType).monetaryAmount(fstAmtEUR).build();

    }
}
