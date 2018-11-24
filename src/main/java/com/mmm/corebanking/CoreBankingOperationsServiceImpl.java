package com.mmm.corebanking;

import com.mmm.corebanking.entities.DepositRequest;
import com.mmm.corebanking.entities.SearchHisotryRequest;
import com.mmm.corebanking.entities.WithdrawalRequest;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class CoreBankingOperationsServiceImpl implements CoreBankingOperationsService {

    private AccountDAO accountDAO;



    @Inject
    public CoreBankingOperationsServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public DepositRequest deposit(long accountId, BigDecimal amount) {

        accountDAO.update(accountId,amount);
        return null;
    }

    @Override
    public WithdrawalRequest withdrawal(long accountId, BigDecimal amount) {
        accountDAO.update(accountId,amount);
        return  null;
    }

    @Override
    public SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest) {
        return null;
    }

}
