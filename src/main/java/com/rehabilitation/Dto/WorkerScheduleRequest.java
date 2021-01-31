package com.rehabilitation.Dto;

import java.sql.Time;
import java.sql.Date;

public class WorkerScheduleRequest {
    private Date date;
    private Time timeFrom;
    private Time timeTo;
    private int location;
    private Long user;

    public WorkerScheduleRequest() {
    }

    public WorkerScheduleRequest(Date date, Time timeFrom, Time timeTo, int location, Long user) {
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.location = location;
        this.user = user;
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

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
