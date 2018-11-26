package com.mmm.corebanking;

import com.mmm.corebanking.accounts.Account;
import com.mmm.corebanking.view.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.math.BigDecimal;

@RestController
@EnableAutoConfiguration
// TODO: required arg constructor with injects
// TODO: annoations spriing sur les interfaces
public class CoreBankingOperationsControllerImpl implements CoreBankingOperationsController {

     private final CoreBankingOperationsProcess coreBankingOperationsProcess;

    @Inject
    public CoreBankingOperationsControllerImpl(CoreBankingOperationsProcess
                                                       coreBankingOperationsProcess){

        this.coreBankingOperationsProcess = coreBankingOperationsProcess;
    }

    @RequestMapping(method = RequestMethod.PUT,path="/deposit")
    public DepositResponse deposit(@RequestBody DepositRequest depositRequest) throws CoreBankingBusinessException {

        Account accountUpdated= coreBankingOperationsProcess.deposit(depositRequest.toTransaction());
        return DepositResponse.builder().accountId(String.valueOf(accountUpdated.getAccountId())).amount(new BigDecimal(accountUpdated.getAmount().getNumber().longValueExact())).build();
    }


    @RequestMapping(method = RequestMethod.PUT,path="/withdrawal")
    public WithdrawalResponse withdrawal(@RequestBody WithdrawalRequest withdrawalRequest) throws CoreBankingBusinessException {
        Account accountUpdated= coreBankingOperationsProcess.withdrawal(withdrawalRequest.toTransaction());
        return WithdrawalResponse.builder().accountId(String.valueOf(accountUpdated.getAccountId())).amount(new BigDecimal(accountUpdated.getAmount().getNumber().longValueExact())).build();
    }

    @RequestMapping(method = RequestMethod.PUT,path="/history")
    public SearchResponse searchHisotry(@RequestBody SearchRequest searchRequest) throws CoreBankingBusinessException {

       return SearchResponse.builder().transactionSet(coreBankingOperationsProcess.searchHisotry(searchRequest.getStartingDate(),searchRequest.getEndingDate())).build();

    }

}
