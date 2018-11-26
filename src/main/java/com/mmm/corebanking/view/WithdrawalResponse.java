package com.mmm.corebanking.view;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@RequiredArgsConstructor
public class WithdrawalResponse {

    // TODO : Utilisation de la currency
    // TODO : Les centimes ?

    private final BigDecimal amount;
    private final String accountId;
}
