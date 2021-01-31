package com.rehabilitation.Dto;

import java.util.Date;

public class RehabilitationPlanRequest {
    private Date creationDate;
    private int patient;

    public RehabilitationPlanRequest() {
    }

    public RehabilitationPlanRequest(int planId, Date creationDate, int patient) {
        this.creationDate = creationDate;
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
}
