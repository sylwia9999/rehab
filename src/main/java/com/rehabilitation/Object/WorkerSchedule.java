package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
public class WorkerSchedule {
    @Id
    @GeneratedValue
    @NotNull
    private int workerScheduleId;
    private Date date;
    private Time timeFrom;
    private Time timeTo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private User worker;

    public WorkerSchedule() {
    }

    public WorkerSchedule(int workerScheduleId, Date date, Time timeFrom, Time timeTo, User worker) {
        this.workerScheduleId = workerScheduleId;
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.worker = worker;
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

    public User getUser() {
        return worker;
    }

    public void setUser(User worker) {
        this.worker = worker;
    }
}
