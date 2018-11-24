package com.mmm.corebanking;

import com.mmm.corebanking.entities.DepositRequest;
import com.mmm.corebanking.entities.SearchHisotryRequest;
import com.mmm.corebanking.entities.WithdrawalRequest;

import javax.inject.Inject;
import javax.inject.Named;

@Named
// required arg constructor with injects
public class CoreBankingOperationsControllerImpl implements CoreBankingOperationsController {

     private final CoreBankingOperationsService coreBankingOperationsService;

    @Inject
    public CoreBankingOperationsControllerImpl(CoreBankingOperationsService
                                                coreBankingOperationsService){

        this.coreBankingOperationsService=coreBankingOperationsService;
    }

    public DepositRequest deposit(DepositRequest depositRequest) {

        coreBankingOperationsService.deposit()
        return null;
    }

    public WithdrawalRequest withdrawal(WithdrawalRequest depositRequest) {
        return null;
    }

    public SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest) {
        return null;
    }

}
