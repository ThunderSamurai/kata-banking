package com.mmm.corebanking;

import com.mmm.corebanking.views.*;

public interface CoreBankingOperationsController {


    DepositResponse deposit(DepositRequest depositRequestt)throws CoreBankingBusinessException;

    WithdrawalResponse withdrawal(WithdrawalRequest depositRequest) throws CoreBankingBusinessException;

    SearchResponse getTransactionHisotry(SearchRequest depositRequest) throws CoreBankingBusinessException;

}
