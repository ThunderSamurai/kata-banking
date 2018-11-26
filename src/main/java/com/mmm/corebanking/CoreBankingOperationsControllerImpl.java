package com.mmm.corebanking;

import com.mmm.corebanking.entities.*;
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

    public WithdrawalRequest withdrawal(WithdrawalRequest depositRequest) {
        return null;
    }

    public SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest) {
        return null;
    }

}
