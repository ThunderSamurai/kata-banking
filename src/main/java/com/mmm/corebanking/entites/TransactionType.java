package com.mmm.corebanking.entites;

public enum TransactionType {

    DEPOSIT  (0),
    WITHDRAWL(1);


        private final int transactionType;

        TransactionType(int transactionType) {
            this.transactionType = transactionType;
        }
}
