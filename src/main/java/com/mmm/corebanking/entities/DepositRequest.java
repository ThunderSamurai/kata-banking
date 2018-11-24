package com.mmm.corebanking.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class DepositRequest {

    // TODO : Utilisation de la currency
    // TODO : Les centimes ?

    private BigDecimal amount;
    private String accountId;
}
