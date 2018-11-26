package com.mmm.corebanking.entities;

public enum TransactionType {

    DEPOSIT  (0),
    WITHDRAWL(1);


        private final int transactionType;

        private TransactionType(int transactionType) {
            this.transactionType = transactionType;
        }
}
