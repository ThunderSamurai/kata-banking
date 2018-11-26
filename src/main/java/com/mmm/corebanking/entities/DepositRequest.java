package com.mmm.corebanking.entities;

import lombok.Builder;
import lombok.Data;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.util.Currency;

import static com.mmm.corebanking.entities.TransactionType.*;
import static com.mmm.corebanking.entities.TransactionType.DEPOSIT;

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
