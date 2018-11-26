package com.mmm.corebanking.accounts;

import com.mmm.corebanking.cutomers.Customer;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.HashSet;
import java.util.Set;

public class AccountTestFactory {

    public static Account createAccount(){

        CurrencyUnit eur = Monetary.getCurrency("EUR");
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory()
                .setCurrency(eur).setNumber(200).create();

        Customer customer=Customer.builder().customerId(1).firstname("toto").lastname("tata").email("xxxx@gmail.com").mobilenumber("0645823687").build();

        Set<Customer> customerSet=new HashSet<Customer>();
        customerSet.add(customer);

        return Account.builder().accountId(1).amount(fstAmtEUR).customers(customerSet).build();


    }
}
