package com.rehabilitation.Dto;

import java.sql.Time;
import java.sql.Date;

public class TreatmentScheduleRequest {
    private Date date;
    private Time timeFrom;
    private Time timeTo;
    private int treatment;
    private Long user;
    private int location;
    private int machine;

    public TreatmentScheduleRequest() {
    }

    public TreatmentScheduleRequest(Date date, Time timeFrom, Time timeTo, int treatment, int location, int machine, Long user) {
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.treatment = treatment;
        this.user = user;
        this.machine = machine;
        this.location = location;
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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getMachine() {
        return machine;
    }

    public void setMachine(int machine) {
        this.machine = machine;
    }
}
