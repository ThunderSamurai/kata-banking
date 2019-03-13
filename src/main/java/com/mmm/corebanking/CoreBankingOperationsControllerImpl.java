package com.mmm.corebanking;

import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.processes.CoreBankingOperationsProcess;
import com.mmm.corebanking.views.*;
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

    @RequestMapping(method = RequestMethod.POST,path="/deposit")
    public DepositResponse deposit(@RequestBody DepositRequest depositRequest) throws CoreBankingBusinessException {

        Account accountUpdated= coreBankingOperationsProcess.deposit(depositRequest.toTransaction());
        return DepositResponse.builder().accountId(String.valueOf(accountUpdated.getAccountId())).amount(new BigDecimal(accountUpdated.getAmount().getNumber().longValueExact())).build();
    }


    @RequestMapping(method = RequestMethod.POST,path="/withdrawal")
    public WithdrawalResponse withdrawal(@RequestBody WithdrawalRequest withdrawalRequest) throws CoreBankingBusinessException {
        Account accountUpdated= coreBankingOperationsProcess.withdrawal(withdrawalRequest.toTransaction());
        return WithdrawalResponse.builder().accountId(String.valueOf(accountUpdated.getAccountId())).amount(new BigDecimal(accountUpdated.getAmount().getNumber().longValueExact())).build();
    }

    @RequestMapping(method = RequestMethod.POST,path="/history")
    public SearchResponse getTransactionHisotry(@RequestBody SearchRequest searchRequest) throws CoreBankingBusinessException {

       return SearchResponse.builder().transactionList(coreBankingOperationsProcess.getTransactionHisotry()).build();

    }

}
