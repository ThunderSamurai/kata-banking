package com.mmm.corebanking.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmm.corebanking.CoreBankingApplication;
import com.mmm.corebanking.entites.*;
import com.mmm.corebanking.services.AccountService;
import com.mmm.corebanking.services.CustomerSerivce;
import com.mmm.corebanking.services.TransactionService;
import com.mmm.corebanking.daos.AccountDaoProviders;
import com.mmm.corebanking.views.DepositRequest;
import com.mmm.corebanking.views.SearchRequest;
import com.mmm.corebanking.views.WithdrawalRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes =CoreBankingApplication.class)
@ActiveProfiles(AccountDaoProviders.MOCK_ACCOUNT_DAO)
@AutoConfigureMockMvc
public class CoreBackingControllerIT {

    @Inject
    private MockMvc mockMvc;

    @Inject
    AccountService accountService;

    @Inject
    TransactionService transactionService;

    @Inject
    CustomerSerivce customerSerivce;

    private Account expectedAccount = null;

    private Customer expectedCustomer=null;

    @Before
    public void init(){

       Customer customer=CustomerTestFactory.create();

       expectedCustomer=customerSerivce.save(customer);

       this.expectedAccount=accountService.save(AccountTestFactory.createAccountWithCustomer(expectedCustomer));

       List<Transaction> transactionList= TransactionTestFactory.createTransactionListWithSameAmount(10, 1L,expectedAccount);

      for(Transaction transaction:transactionList) {
          transactionService.save(transaction);
      }

    }
    @Test
    public void should_make_deposit() throws Exception {

        //GIVEN
        DepositRequest depositRequest= DepositRequest.builder().customerId(String.valueOf(expectedCustomer.getCustomerId())).transactionId("11").accountId(String.valueOf(expectedAccount.getAccountId())).amount(10).currency("EUR").transactionType(0).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(depositRequest);

        //WHEN-THEN
        this.mockMvc.perform(put("/deposit").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void should_make_withdrawal() throws Exception {

        //GIVEN
        WithdrawalRequest withdrawalRequest= WithdrawalRequest.builder().customerId(String.valueOf(expectedCustomer.getCustomerId())).transactionId("12").accountId(String.valueOf(expectedAccount.getAccountId())).amount(10).currency("EUR").transactionType(1).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(withdrawalRequest);

        //WHEN-THEN
        this.mockMvc.perform(put("/withdrawal").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andDo(print()).andExpect(status().isOk());
    }


    @Test
    public void should_search_history() throws Exception {

        //GIVEN
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(Calendar.getInstance().getTime());
        calendar.roll(Calendar.MONTH,6);

        SearchRequest searchRequest= SearchRequest.builder().accountId(String.valueOf(expectedAccount.getAccountId())).startingDate(calendar.getTime()).endingDate(Calendar.getInstance().getTime()).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(searchRequest);

        //WHEN-THEN
       this.mockMvc.perform(put("/history").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andDo(print()).andExpect(status().isOk());
    }


}
