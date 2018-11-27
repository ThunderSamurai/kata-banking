package com.mmm.corebanking.entites;

import java.util.Random;

public class CustomerTestFactory {

    private static Random RANDOM_1=new Random();

    public static Customer create(){
        return Customer.builder().id(RANDOM_1.nextLong()).customerId(RANDOM_1.nextLong()).firstname("toto").lastname("tata").email(""+RANDOM_1.nextLong()+"@gmail.com").mobileNumber("0645823687"+RANDOM_1.nextLong()).build();
    }
}
