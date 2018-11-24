package com.mmm.corebanking;

import com.mmm.corebanking.entities.DepositRequest;
import com.mmm.corebanking.entities.SearchHisotryRequest;
import com.mmm.corebanking.entities.WithdrawalRequest;

import java.math.BigDecimal;

public interface CoreBankingOperationsService {


    DepositRequest deposit(long accountId, BigDecimal amount);

    WithdrawalRequest withdrawal(long accountId, BigDecimal amount);

    SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest);

}
