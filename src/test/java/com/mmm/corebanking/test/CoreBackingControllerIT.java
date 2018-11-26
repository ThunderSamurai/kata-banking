package com.mmm.corebanking.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmm.corebanking.view.DepositRequest;
import com.mmm.corebanking.view.SearchRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

import java.util.Calendar;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoreBackingControllerIT {

    @Inject
    private MockMvc mockMvc;

    @Test
    public void should_make_deposit() throws Exception {

        DepositRequest depositRequest= DepositRequest.builder().accountId("1").amount(10).currency("EUR").transactionType(0).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(depositRequest);
        this.mockMvc.perform(put("/deposit").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void should_make_withdrawal() throws Exception {

        DepositRequest depositRequest= DepositRequest.builder().accountId("1").amount(10).currency("EUR").transactionType(1).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(depositRequest);
        this.mockMvc.perform(put("/withdrawal").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andDo(print()).andExpect(status().isOk());
    }


    @Test
    public void should_search_history() throws Exception {

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(Calendar.getInstance().getTime());
        calendar.roll(Calendar.MONTH,6);



        SearchRequest searchRequest= SearchRequest.builder().accountId("1").startingDate(calendar.getTime()).endingDate(Calendar.getInstance().getTime()).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(searchRequest);
        this.mockMvc.perform(put("/history").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andDo(print()).andExpect(status().isOk());
    }


}
