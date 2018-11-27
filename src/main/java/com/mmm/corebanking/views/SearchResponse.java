package com.mmm.corebanking.views;

import com.mmm.corebanking.entites.Transaction;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class SearchResponse {


   private List<Transaction> transactionList;
}
