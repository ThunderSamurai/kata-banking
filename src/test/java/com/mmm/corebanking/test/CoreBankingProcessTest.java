package com.mmm.corebanking.test;

import com.mmm.corebanking.accounts.AccountService;
import com.mmm.corebanking.CoreBankingBusinessException;
import com.mmm.corebanking.CoreBankingOperationsProcessImpl;
import com.mmm.corebanking.accounts.transactions.TransactionService;
import com.mmm.corebanking.accounts.Account;
import com.mmm.corebanking.accounts.AccountTestFactory;
import com.mmm.corebanking.accounts.transactions.Transaction;
import com.mmm.corebanking.accounts.transactions.TransactionTestFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
        when(accountService.findById(anyLong())).thenReturn(account);

        //WHEN
        coreBankingOperationsProcess.deposit(TransactionTestFactory.createDepositTransaction(10,account));

        //THEN
        // No Exceptions
    }

    @Test(expected = CoreBankingBusinessException.class)
    public void should_throw_exception_for_invalid_deposit_data() throws Exception {


        //GIVEN
        Account account= AccountTestFactory.createAccount();
        when(accountService.findById(anyLong())).thenReturn(account);

        //WHEN
        coreBankingOperationsProcess.deposit(TransactionTestFactory.createWithdrawalTransaction(10,account));

        //THEN
        // Throw exception
    }

    @Test
    public void should_make_withdrawal_with_valid_data() throws Exception {


        //GIVEN
        Account account= AccountTestFactory.createAccount();
        when(accountService.findById(anyLong())).thenReturn(account);

        //WHEN
        coreBankingOperationsProcess.withdrawal(TransactionTestFactory.createWithdrawalTransaction(10,account));

        //THEN
        // No Exceptions
    }

    @Test(expected = CoreBankingBusinessException.class)
    public void should_throw_exception_for_invalid_withdrawal_data() throws Exception {


        //GIVEN
        Account account= AccountTestFactory.createAccount();
        when(accountService.findById(anyLong())).thenReturn(account);

        //WHEN
        coreBankingOperationsProcess.withdrawal(TransactionTestFactory.createDepositTransaction(10,account));

        //THEN
        // Throw exception
    }


    @Test
    public void should_process_search_with_valid_data() throws Exception {

        //GIVEN
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(Calendar.getInstance().getTime());
        calendar.roll(Calendar.MONTH,6);

        when(transactionService.getTransactionsByDate(any(Date.class),any(Date.class))).thenReturn(TransactionTestFactory.createTransactionListWithSameAmount(10,AccountTestFactory.createAccount()));


        //WHEN
       Set<Transaction> transactions=coreBankingOperationsProcess.searchHisotry(calendar.getTime(),Calendar.getInstance().getTime());

        //THEN
        assertThat(transactions).isNotEmpty();
    }

    @Test(expected = CoreBankingBusinessException.class)
    public void should_throw_exception_for_invalid_search_data() throws Exception {


        //GIVEN
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(Calendar.getInstance().getTime());
        calendar.roll(Calendar.MONTH,6);

        //WHEN
        coreBankingOperationsProcess.searchHisotry(Calendar.getInstance().getTime(),calendar.getTime());

        //THEN
        // Throw exception
    }

}
