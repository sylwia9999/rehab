package com.rehabilitation.Dto;

import java.sql.Time;
import java.util.Date;

public class TreatmentScheduleResponse {
    private int treatmentScheduleId;
    private Date date;
    private Time timeFrom;
    private Time timeTo;
    private int treatment;

    public TreatmentScheduleResponse() {
    }

    public TreatmentScheduleResponse(int treatmentScheduleId, Date date, Time timeFrom, Time timeTo, int treatment) {
        this.treatmentScheduleId = treatmentScheduleId;
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.treatment = treatment;
    }

    public int getTreatment_schedule_id() {
        return treatmentScheduleId;
    }

    public void setTreatment_schedule_id(int treatmentScheduleId) {
        this.treatmentScheduleId = treatmentScheduleId;
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
