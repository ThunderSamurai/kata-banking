package com.mmm.corebanking.services;

import com.mmm.corebanking.daos.TransactionDAO;
import com.mmm.corebanking.entites.Transaction;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

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
    public Transaction findByTransactionId(Long transactionId) {
        return transactionDAO.findByTransactionId(transactionId);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionDAO.findAll();
    }

}
