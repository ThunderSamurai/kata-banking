package com.mmm.corebanking.entites;

import com.mmm.corebanking.utils.MoneyUtils;

import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AccountTestFactory {

    private final static Random RANDOM_2 = new Random();
    private final static Random RANDOM_3 = new Random();

    public static Account createAccount(){

        MonetaryAmount fstAmtEUR = MoneyUtils.createEuroMonetaryAmount(200);

        List<Customer> customerList=new ArrayList<>();
        customerList.add(CustomerTestFactory.create());

        return Account.builder().id(RANDOM_3.nextLong()).accountId(RANDOM_2.nextLong()).amount(fstAmtEUR).customers(customerList).build();


    }

    public static Account createAccountWithCustomer(Customer customer) {


        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        MonetaryAmount fstAmtEUR = MoneyUtils.createEuroMonetaryAmount(200);

        return Account.builder().id(RANDOM_3.nextLong()).accountId(RANDOM_2.nextLong()).amount(fstAmtEUR).customers(customerList).build();


    }
}

