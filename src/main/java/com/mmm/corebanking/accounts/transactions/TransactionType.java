package com.mmm.corebanking.accounts.transactions;

public enum TransactionType {

    DEPOSIT  (0),
    WITHDRAWL(1);


        private final int transactionType;

        private TransactionType(int transactionType) {
            this.transactionType = transactionType;
        }
}
