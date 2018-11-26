package com.mmm.corebanking.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositResponse {

    // TODO : Utilisation de la currency
    // TODO : Les centimes ?

    private BigDecimal amount=new BigDecimal(10);
    private String accountId="1";
}
