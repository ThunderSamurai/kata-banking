package com.mmm.corebanking.view;

import com.mmm.corebanking.accounts.transactions.Transaction;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;


@Entity
@Data
@Builder
public class SearchResponse {


   private Set<Transaction> transactionSet;
}
