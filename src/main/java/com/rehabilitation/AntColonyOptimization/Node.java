package com.rehabilitation.AntColonyOptimization;

import java.sql.Time;
import java.sql.Date;

public class Node {
    int machineId;
    Long workerId;
    Date date;
    Time startTime;

    public Node() {
    }

    public Node(int machineId, Long workerId, Date date, Time startTime) {
        this.machineId = machineId;
        this.workerId = workerId;
        this.date = date;
        this.startTime = startTime;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
}
