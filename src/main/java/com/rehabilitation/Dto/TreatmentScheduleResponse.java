package com.rehabilitation.Dto;

import java.sql.Time;
import java.sql.Date;
import java.util.Optional;

public class TreatmentScheduleResponse {
    private int treatmentScheduleId;
    private Optional<Date> date;
    private Optional<Time> timeFrom;
    private Optional<Time> timeTo;
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

    public Optional<Date> getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = Optional.ofNullable(date);
    }

    public Optional<Time> getTime_from() {
        return timeFrom;
    }

    public void setTime_from(Time timeFrom) {
        this.timeFrom = Optional.ofNullable(timeFrom);
    }

    public Optional<Time> getTime_to() {
        return timeTo;
    }

    public void setTime_to(Time timeTo) {
        this.timeTo = Optional.ofNullable(timeTo);
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
