package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.DepositRequest;
import com.mmm.corebanking.entities.SearchHisotryRequest;
import com.mmm.corebanking.entities.Transaction;

import javax.inject.Inject;

public class CoreBankingProcessImpl implements CoreBankingProcess {

    private final CoreBankingOperationsService coreBankingOperationsService;

    @Inject
    public CoreBankingProcessImpl(CoreBankingOperationsService
                                                       coreBankingOperationsService){

        this.coreBankingOperationsService=coreBankingOperationsService;
    }

    @Override
    public Account deposit(DepositRequest depositRequest) throws CoreBankingBusinessException {

        Account account=
        return null;
    }

    @Override
    public Account withdrawal(Account account, Transaction transaction) throws CoreBankingBusinessException {
        return null;
    }

    @Override
    public SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest) {
        return null;
    }
}
