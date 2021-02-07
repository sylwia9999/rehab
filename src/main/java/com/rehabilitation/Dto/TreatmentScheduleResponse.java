package com.rehabilitation.Dto;

import java.sql.Time;
import java.sql.Date;
import java.util.Optional;

public class TreatmentScheduleResponse {
    private int treatmentScheduleId;
    private Date date;
    private Time timeFrom;
    private Time timeTo;
    private Long user;
    private int location;
    private int machine;
    private int treatment;

    public TreatmentScheduleResponse() {
    }

    public TreatmentScheduleResponse(int treatmentScheduleId, Long user, int location, int machine, int treatment) {
        this.treatmentScheduleId = treatmentScheduleId;
        this.user = user;
        this.location = location;
        this.machine = machine;
        this.treatment = treatment;
    }

    public int getTreatment_schedule_id() {
        return treatmentScheduleId;
    }

    public void setTreatment_schedule_id(int treatmentScheduleId) {
        this.treatmentScheduleId = treatmentScheduleId;
    }

    public TreatmentScheduleResponse(int treatmentScheduleId, Date date, Time timeFrom, Time timeTo, Long user, int location, int machine, int treatment) {
        this.treatmentScheduleId = treatmentScheduleId;
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.user = user;
        this.location = location;
        this.machine = machine;
        this.treatment = treatment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Time timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Time timeTo) {
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
