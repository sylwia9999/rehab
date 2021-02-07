package com.rehabilitation.Dto;

import java.sql.Date;

public class RehabilitationPlanRequest {
    private Date creationDate;
    private Date startDate;
    private int patient;

    public RehabilitationPlanRequest() {
    }

    public RehabilitationPlanRequest(Date creationDate, int patient, Date startDate) {
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.patient = patient;
    }

    public Date getCreation_date() {
        return creationDate;
    }

    public void setCreation_date(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
