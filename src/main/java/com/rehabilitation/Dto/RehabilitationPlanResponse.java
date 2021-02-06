package com.rehabilitation.Dto;

import java.util.Date;

public class RehabilitationPlanResponse {
    private int planId;
    private Date creationDate;
    private Date startDate;
    private int patient;

    public RehabilitationPlanResponse() {
    }

    public RehabilitationPlanResponse(int planId, Date creationDate, int patient, Date startDate) {
        this.planId = planId;
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.patient = patient;
    }

    public int getPlan_id() {
        return planId;
    }

    public void setPlan_id(int planId) {
        this.planId = planId;
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
