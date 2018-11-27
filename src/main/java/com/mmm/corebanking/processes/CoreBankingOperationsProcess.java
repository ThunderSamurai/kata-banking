package com.mmm.corebanking.processes;

import com.mmm.corebanking.CoreBankingBusinessException;
import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.entites.Transaction;

import java.util.List;

public interface CoreBankingOperationsProcess {



    Account deposit(Transaction transaction) throws CoreBankingBusinessException;

    Account withdrawal(Transaction transaction) throws CoreBankingBusinessException;

    List<Transaction> getTransactionHisotry() throws CoreBankingBusinessException;

}
