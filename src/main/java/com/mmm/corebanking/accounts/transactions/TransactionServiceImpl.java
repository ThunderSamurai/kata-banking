package com.mmm.corebanking.accounts.transactions;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.Set;

@Named
public class TransactionServiceImpl implements TransactionService {

    private final TransactionDAO transactionDAO;

    @Inject
    public TransactionServiceImpl(TransactionDAO transactionDAO){

        this.transactionDAO=transactionDAO;

    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionDAO.save(transaction);
    }

    @Override
    public Transaction findById(long transactionId) {
        return transactionDAO.findById(transactionId);
    }

    @Override
    public Set<Transaction> getTransactionsByDate(Date startingDate, Date endingDate) {
        return transactionDAO.getTransactionsByDate(startingDate,endingDate);
    }

}
