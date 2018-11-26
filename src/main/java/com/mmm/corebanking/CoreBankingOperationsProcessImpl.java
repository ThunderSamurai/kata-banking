package com.mmm.corebanking;

import com.mmm.corebanking.accounts.Account;
import com.mmm.corebanking.accounts.AccountService;
import com.mmm.corebanking.accounts.transactions.Transaction;
import com.mmm.corebanking.accounts.transactions.TransactionService;
import com.mmm.corebanking.accounts.transactions.TransactionType;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.Set;

@Named
public class CoreBankingOperationsProcessImpl implements CoreBankingOperationsProcess {

    private final AccountService accountService;

    private final TransactionService transactionService;

    @Inject
    public CoreBankingOperationsProcessImpl(AccountService accountService, TransactionService transactionService){
        this.accountService = accountService;
        this.transactionService = transactionService;
    }


    @Override
    public Account deposit( Transaction transaction) throws CoreBankingBusinessException {
        Account accountToUpdate=accountService.findById(transaction.getAccount().getAccountId());

        validateDepositTransaction(transaction);

        accountToUpdate.setAmount(accountToUpdate.getAmount().add(transaction.getMonetaryAmount()));

        transactionService.save(transaction);
        return accountService.save(accountToUpdate);
    }

    private void validateDepositTransaction(Transaction transaction) throws CoreBankingBusinessException {
        /**
          All validation calls and operations should be done here
        * */
        if(!transaction.getTransactionType().equals(TransactionType.DEPOSIT)) throw new CoreBankingBusinessException("invalid deposit data");
    }

    @Override
    public Account withdrawal(Transaction transaction) throws CoreBankingBusinessException {
        Account accountToUpdate=accountService.findById(transaction.getAccount().getAccountId());

        validateWithdrawalTransaction(transaction);

        accountToUpdate.setAmount(accountToUpdate.getAmount().subtract(transaction.getMonetaryAmount()));

        transactionService.save(transaction);

        return accountService.save(accountToUpdate);

    }

    private void validateWithdrawalTransaction( Transaction transaction) throws CoreBankingBusinessException {
        /**
         All validation calls and operations should be done here
         * */
        if(!transaction.getTransactionType().equals(TransactionType.WITHDRAWL)) throw new CoreBankingBusinessException("invalid withdrawal data");
    }

    @Override
    public Set<Transaction> searchHisotry(Date startingDate, Date endingDate ) throws CoreBankingBusinessException {

        validateSearchRequest(startingDate, endingDate);
        return transactionService.getTransactionsByDate(startingDate,endingDate);
    }

    private void validateSearchRequest(Date startingDate, Date endingDate) throws CoreBankingBusinessException {

        /**
         All validation calls and operations should be done here
         * */
        if(startingDate.after(endingDate)) throw new CoreBankingBusinessException("invalid search request data");
    }

}
