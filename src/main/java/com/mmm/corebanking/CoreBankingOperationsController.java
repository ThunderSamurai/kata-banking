package com.mmm.corebanking;

import com.mmm.corebanking.view.*;

public interface CoreBankingOperationsController {


    DepositResponse deposit(DepositRequest depositRequestt)throws CoreBankingBusinessException;

    WithdrawalResponse withdrawal(WithdrawalRequest depositRequest) throws CoreBankingBusinessException;

    SearchResponse searchHisotry(SearchRequest depositRequest) throws CoreBankingBusinessException;

}
