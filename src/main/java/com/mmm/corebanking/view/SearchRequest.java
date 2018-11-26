package com.mmm.corebanking.view;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;


@Entity
@Data
@Builder
public class SearchRequest {


    private final String accountId;

    private final Date startingDate;

    private final Date endingDate;
}
