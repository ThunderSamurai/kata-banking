package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.Transaction;

import javax.inject.Inject;
import javax.inject.Named;

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

}
