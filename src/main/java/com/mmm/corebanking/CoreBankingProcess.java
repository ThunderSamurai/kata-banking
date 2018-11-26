package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.DepositRequest;
import com.mmm.corebanking.entities.SearchHisotryRequest;
import com.mmm.corebanking.entities.Transaction;

public interface CoreBankingProcess {

    Account deposit(DepositRequest depositRequest) throws CoreBankingBusinessException;

    Account withdrawal(Account account, Transaction transaction) throws CoreBankingBusinessException;

    SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest);

}
