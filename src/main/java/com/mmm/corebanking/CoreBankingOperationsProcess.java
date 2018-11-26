package com.mmm.corebanking;

import com.mmm.corebanking.entities.*;

import java.math.BigDecimal;

public interface CoreBankingOperationsProcess {


    Account deposit(Transaction transaction) throws CoreBankingBusinessException;

    Account withdrawal(Account account, Transaction transaction) throws CoreBankingBusinessException;

    SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest);

}
