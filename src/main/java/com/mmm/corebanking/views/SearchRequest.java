package com.mmm.corebanking.views;

import lombok.Builder;
import lombok.Data;

import java.util.Date;



@Data
@Builder
public class SearchRequest {


    private final String accountId;

    private final Date startingDate;

    private final Date endingDate;
}
