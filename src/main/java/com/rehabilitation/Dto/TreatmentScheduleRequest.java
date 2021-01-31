package com.rehabilitation.Dto;

import java.sql.Time;
import java.util.Date;

public class TreatmentScheduleRequest {
    private Date date;
    private Time timeFrom;
    private Time timeTo;
    private int treatment;

    public TreatmentScheduleRequest() {
    }

    public TreatmentScheduleRequest(Date date, Time timeFrom, Time timeTo, int treatment) {
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.treatment = treatment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime_from() {
        return timeFrom;
    }

    public void setTime_from(Time timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Time getTime_to() {
        return timeTo;
    }

    public void setTime_to(Time timeTo) {
        this.timeTo = timeTo;
    }

    public int getTreatment() {
        return treatment;
    }

    public void setTreatment(int treatment) {
        this.treatment = treatment;
    }
}
