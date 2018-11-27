package com.mmm.corebanking.daos.jpa;

import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.entites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction,Long>{

    Transaction findByTransactionId(Long transactionId);
    List<Transaction> findByAccount(Account account);


    List<Transaction>  findAllByCreationDateBetween(
            Date startingDate,
            Date endingDate);
}
