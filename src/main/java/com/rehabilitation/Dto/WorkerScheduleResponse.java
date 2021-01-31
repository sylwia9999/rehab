package com.rehabilitation.Dto;

import java.sql.Time;
import java.sql.Date;

public class WorkerScheduleResponse {
    private int workerScheduleId;
    private Date date;
    private Time timeFrom;
    private Time timeTo;
    private int location;
    private Long user;

    public WorkerScheduleResponse() {
    }

    public WorkerScheduleResponse(int workerScheduleId, Date date, Time timeFrom, Time timeTo, int location, Long user) {
        this.workerScheduleId = workerScheduleId;
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.location = location;
        this.user = user;
    }

    public int getWorker_schedule_id() {
        return workerScheduleId;
    }

    public void setWorker_schedule_id(int workerScheduleId) {
        this.workerScheduleId = workerScheduleId;
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
