package com.mmm.corebanking;

import com.mmm.corebanking.entities.DepositRequest;
import com.mmm.corebanking.entities.SearchHisotryRequest;
import com.mmm.corebanking.entities.WithdrawalRequest;

public interface CoreBankingOperationsController {


    DepositRequest deposit(String depositRequest,String amount);

    WithdrawalRequest withdrawal(WithdrawalRequest depositRequest);

    SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest);

}
