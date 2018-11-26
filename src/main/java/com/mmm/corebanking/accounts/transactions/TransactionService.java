package com.mmm.corebanking.accounts.transactions;

import java.util.Date;
import java.util.Set;

public interface TransactionService {


    /*
        Return the updated account
     */
    Transaction save(Transaction account);


    Transaction findById(long transactionId);

    Set<Transaction> getTransactionsByDate(Date startingDate, Date endingDate);
}
