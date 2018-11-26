package com.mmm.corebanking;

import com.mmm.corebanking.accounts.Account;
import com.mmm.corebanking.accounts.transactions.Transaction;

import java.util.Date;
import java.util.Set;

public interface CoreBankingOperationsProcess {


    Account deposit(Transaction transaction) throws CoreBankingBusinessException;

    Account withdrawal(Transaction transaction) throws CoreBankingBusinessException;

    Set<Transaction> searchHisotry(Date startingDate, Date endingDate) throws CoreBankingBusinessException;

}
