package com.mmm.corebanking;

import com.mmm.corebanking.entities.*;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CoreBankingOperationsProcessImpl implements CoreBankingOperationsProcess {

    private final AccountDAO accountDAO;

    private final TransactionDAO transactionDAO;

    @Inject
    public CoreBankingOperationsProcessImpl(AccountDAO accountDAO, TransactionDAO transactionDAO){
        this.accountDAO = accountDAO;
        this.transactionDAO = transactionDAO;
    }


    @Override
    public Account deposit( Transaction transaction) throws CoreBankingBusinessException {

        Account accountToUpdate=accountDAO.findById(transaction.getAccount().getAccountId());
        validateDepositTransaction(transaction);

        transactionDAO.save(transaction);
        return accountDAO.save(accountToUpdate);
    }

    private void validateDepositTransaction(Transaction transaction) throws CoreBankingBusinessException {
        /**
          All validation calls and operations should be done here
        * */
        if(!transaction.getTransactionType().equals(TransactionType.DEPOSIT)) throw new CoreBankingBusinessException("invalid deposit data");
    }

    @Override
    public Account withdrawal(Account account, Transaction transaction) throws CoreBankingBusinessException {
        validateWithdrawalTransaction(account,transaction);

        transactionDAO.save(transaction);
        return accountDAO.save(account);

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
