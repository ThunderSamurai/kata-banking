package com.mmm.corebanking;

import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.entities.DepositRequest;
import com.mmm.corebanking.entities.SearchHisotryRequest;
import com.mmm.corebanking.entities.WithdrawalRequest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.math.BigDecimal;

@RestController
@EnableAutoConfiguration
// TODO: required arg constructor with injects
// TODO: annoations spriing sur les interfaces
public class CoreBankingOperationsControllerImpl implements CoreBankingOperationsController {

     private final CoreBankingOperationsService coreBankingOperationsService;

     private final CoreBankingProcess coreBankingProcess;

    @Inject
    public CoreBankingOperationsControllerImpl(CoreBankingOperationsService
                                                       coreBankingOperationsService, CoreBankingProcess coreBankingProcess){

        this.coreBankingOperationsService=coreBankingOperationsService;
        this.coreBankingProcess = coreBankingProcess;
    }

    @RequestMapping(method = RequestMethod.PUT,path="/deposit")
    public DepositRequest deposit(@RequestBody DepositRequest depositRequest) {

        coreBankingProcess.deposit(depositRequest);
        return new DepositRequest();
    }

    public WithdrawalRequest withdrawal(WithdrawalRequest depositRequest) {
        return null;
    }

    public SearchHisotryRequest searchHisotry(SearchHisotryRequest depositRequest) {
        return null;
    }

}
