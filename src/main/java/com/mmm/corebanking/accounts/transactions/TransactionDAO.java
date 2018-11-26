package com.mmm.corebanking.accounts.transactions;

import java.util.Date;
import java.util.Set;

public interface TransactionDAO {


    /*
        Return the updated account
     */
    Transaction save(Transaction transaction);


    Transaction findById(long transactionId);

    Set<Transaction> getTransactionsByDate(Date startingDate, Date endingDate);
}
