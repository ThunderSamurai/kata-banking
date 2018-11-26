package com.mmm.corebanking.accounts.transactions;

import com.mmm.corebanking.shared.entities.AbstractTrackedEntity;
import com.mmm.corebanking.accounts.Account;
import lombok.Builder;
import lombok.Data;

import javax.money.MonetaryAmount;
import javax.persistence.*;

@Entity
@Data
@Builder
public class Transaction extends AbstractTrackedEntity {


    @Id
    private final long transactionId;

    private final TransactionType transactionType;

    private final MonetaryAmount monetaryAmount;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;
}
