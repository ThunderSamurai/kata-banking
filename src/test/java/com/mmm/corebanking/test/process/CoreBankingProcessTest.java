package com.mmm.corebanking.test.process;

import com.mmm.corebanking.CoreBankingBusinessException;
import com.mmm.corebanking.entites.Account;
import com.mmm.corebanking.entites.AccountTestFactory;
import com.mmm.corebanking.entites.TransactionTestFactory;
import com.mmm.corebanking.processes.CoreBankingOperationsProcessImpl;
import com.mmm.corebanking.services.AccountService;
import com.mmm.corebanking.services.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoreBankingProcessTest {


    @Mock
    AccountService accountService;

    @Mock
    TransactionService transactionService;


    @InjectMocks
    CoreBankingOperationsProcessImpl coreBankingOperationsProcess;

    @Test
    public void should_make_deposit_with_valid_data() throws Exception {


        //GIVEN
        Account account= AccountTestFactory.createAccount();
        when(accountService.findByAccountId(anyLong())).thenReturn(account);

        //WHEN
        coreBankingOperationsProcess.deposit(TransactionTestFactory.createDepositTransaction(10,1,account));

        //THEN
        // No Exceptions
    }

    @Test(expected = CoreBankingBusinessException.class)
    public void should_throw_exception_for_invalid_deposit_data() throws Exception {


        //GIVEN
        Account account= AccountTestFactory.createAccount();
        when(accountService.findByAccountId(anyLong())).thenReturn(account);

        //WHEN
        coreBankingOperationsProcess.deposit(TransactionTestFactory.createWithdrawalTransaction(10,1,account));

        //THEN
        // Throw exception
    }

    @Test
    public void should_make_withdrawal_with_valid_data() throws Exception {


        //GIVEN
        Account account= AccountTestFactory.createAccount();
        when(accountService.findByAccountId(anyLong())).thenReturn(account);

        //WHEN
        coreBankingOperationsProcess.withdrawal(TransactionTestFactory.createWithdrawalTransaction(10,1,account));

        //THEN
        // No Exceptions
    }

    @Test(expected = CoreBankingBusinessException.class)
    public void should_throw_exception_for_invalid_withdrawal_data() throws Exception {


        //GIVEN
        Account account= AccountTestFactory.createAccount();
        when(accountService.findByAccountId(anyLong())).thenReturn(account);

        //WHEN
        coreBankingOperationsProcess.withdrawal(TransactionTestFactory.createDepositTransaction(10,1,account));

        //THEN
        // Throw exception
    }

}
