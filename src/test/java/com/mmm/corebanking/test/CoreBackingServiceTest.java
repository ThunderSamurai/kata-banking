package com.mmm.corebanking.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmm.corebanking.entities.DepositRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoreBackingServiceTest {

    @Inject
    private MockMvc mockMvc;

    @Test
    public void should_make_deposit() throws Exception {

        DepositRequest depositRequest= DepositRequest.builder().accountId("1").amount(10).currency("EUR").transactionType(0).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(depositRequest);
        this.mockMvc.perform(put("/deposit").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andDo(print()).andExpect(status().isOk());
    }

}
