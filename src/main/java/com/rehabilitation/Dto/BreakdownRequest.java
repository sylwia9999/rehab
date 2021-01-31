package com.rehabilitation.Dto;

import java.sql.Date;

public class BreakdownRequest {
    private Date dateFrom;
    private Date dateTo;
    private int machineId;

    public BreakdownRequest() {
    }

    public BreakdownRequest(Date dateFrom, Date dateTo, int machineId) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.machineId = machineId;
    }


    public Date getDate_from() {
        return dateFrom;
    }

    public void setDate_from(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDate_to() {
        return dateTo;
    }

    public void setDate_to(Date dateTo) {
        this.dateTo = dateTo;
    }

    public int getMachine() {
        return machineId;
    }

    public void setMachine(int machineId) {
        this.machineId = machineId;
    }
}
