package com.mmm.corebanking.utils;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

public class MoneyUtils {

    public static MonetaryAmount createEuroMonetaryAmount(long amount){

        CurrencyUnit eur = Monetary.getCurrency("EUR");
       return Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(amount).create();
    }

    public static MonetaryAmount createEuroMonetaryAmount(long amount,String codeCurrency){

        CurrencyUnit eur = Monetary.getCurrency(codeCurrency);
        return Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(amount).create();
    }
}
