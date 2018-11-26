package com.mmm.corebanking;

import com.mmm.corebanking.entities.DepositRequest;
import com.mmm.corebanking.entities.DepositResponse;
import com.mmm.corebanking.entities.SearchHisotryRequest;
import com.mmm.corebanking.entities.WithdrawalRequest;

public interface CoreBankingOperationsController {


    DepositResponse deposit(DepositRequest depositRequestt)throws CoreBankingBusinessException;

    WithdrawalRequest withdrawal(WithdrawalRequest depositRequest);

    SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest);

}
