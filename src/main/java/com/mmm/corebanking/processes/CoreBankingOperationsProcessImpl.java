package com.mmm.corebanking.processes;

import com.mmm.corebanking.CoreBankingBusinessException;
import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.entites.Transaction;
import com.mmm.corebanking.entites.TransactionType;
import com.mmm.corebanking.services.AccountService;
import com.mmm.corebanking.services.CustomerSerivce;
import com.mmm.corebanking.services.TransactionService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CoreBankingOperationsProcessImpl implements CoreBankingOperationsProcess {

    private final AccountService accountService;

    private final TransactionService transactionService;

    private final CustomerSerivce customerSerivce;

    @Inject
    public CoreBankingOperationsProcessImpl(AccountService accountService, TransactionService transactionService, CustomerSerivce customerSerivce){
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.customerSerivce = customerSerivce;
    }


    @Override
    public Account deposit(Transaction transaction) throws CoreBankingBusinessException {
        Account accountToUpdate=accountService.findByAccountId(transaction.getAccount().getAccountId());

        validateDepositTransaction(transaction);

        transaction.setAccount(accountToUpdate);

        accountToUpdate.setAmount(accountToUpdate.getAmount().add(transaction.getMonetaryAmount()));
        Account updatedAccount=accountService.save(accountToUpdate);
        transactionService.save(transaction);
        return updatedAccount;
    }

    private void validateDepositTransaction(Transaction transaction) throws CoreBankingBusinessException {
        /**
          All validation calls and operations should be done here
        * */
        if(!transaction.getTransactionType().equals(TransactionType.DEPOSIT)) throw new CoreBankingBusinessException("invalid deposit data");
    }

    @Override
    public Account withdrawal(Transaction transaction) throws CoreBankingBusinessException {
        Account accountToUpdate=accountService.findByAccountId(transaction.getAccount().getAccountId());

        validateWithdrawalTransaction(transaction);

        transaction.setAccount(accountToUpdate);

        accountToUpdate.setAmount(accountToUpdate.getAmount().subtract(transaction.getMonetaryAmount()));
        Account updatedAccount=accountService.save(accountToUpdate);
        transactionService.save(transaction);
        return updatedAccount;

    }

    private void validateWithdrawalTransaction( Transaction transaction) throws CoreBankingBusinessException {
        /**
         All validation calls and operations should be done here
         * */
        if(!transaction.getTransactionType().equals(TransactionType.WITHDRAWL)) throw new CoreBankingBusinessException("invalid withdrawal data");
    }

    @Override
    public List<Transaction> getTransactionHisotry( ) throws CoreBankingBusinessException {

        validateSearchRequest();
        return transactionService.findAll();
    }

    private void validateSearchRequest() throws CoreBankingBusinessException {

        /**
         All validation calls and operations should be done here
         * */
        if(false) throw new CoreBankingBusinessException("invalid search request data");
    }

}
