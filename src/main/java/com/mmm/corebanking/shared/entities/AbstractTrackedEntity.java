package com.mmm.corebanking.shared.entities;

import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

public abstract class AbstractTrackedEntity {

    @Id
    private long id;

    private Date creationDate= Calendar.getInstance().getTime();

    private String creationUser="MMM";

    private Date lastupdateDate=Calendar.getInstance().getTime();
}
