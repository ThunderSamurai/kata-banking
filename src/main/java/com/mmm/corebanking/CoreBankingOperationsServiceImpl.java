package com.mmm.corebanking;

import com.mmm.corebanking.entities.*;

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
    public Account deposit(Account account, Transaction transaction) throws CoreBankingBusinessException {
        validateDepositTransaction(account,transaction);
        return accountDAO.save(account,transaction);
    }

    private void validateDepositTransaction(Account account, Transaction transaction) throws CoreBankingBusinessException {
        /**
          All validation calls and operations should be done here
        * */
        if(!transaction.getTransactionType().equals(TransactionType.DEPOSIT)) throw new CoreBankingBusinessException("invalid deposit data");
    }

    @Override
    public Account withdrawal(Account account, Transaction transaction) throws CoreBankingBusinessException {
        validateWithdrawalTransaction(account,transaction);
        return accountDAO.save(account,transaction);
    }

    private void validateWithdrawalTransaction(Account account, Transaction transaction) throws CoreBankingBusinessException {
        /**
         All validation calls and operations should be done here
         * */
        if(!transaction.getTransactionType().equals(TransactionType.WITHDRAWL)) throw new CoreBankingBusinessException("invalid withdrawal data");
    }

    @Override
    public SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest) {
        return null;
    }

}
