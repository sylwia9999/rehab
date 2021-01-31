package com.rehabilitation.Dto;

import java.sql.Date;
import java.util.Optional;

public class BreakdownResponse {
    private int breakdownId;
    private Date dateFrom;
    private Optional<Date> dateTo;
    private int machineId;

    public BreakdownResponse() {
    }

    public BreakdownResponse(int breakdownId, Date dateFrom, Date dateTo, int machineId) {
        this.breakdownId = breakdownId;
        this.dateFrom = dateFrom;
        this.dateTo = Optional.ofNullable(dateTo);
        this.machineId = machineId;
    }

    public int getBreakdownId() {
        return breakdownId;
    }

    public void setBreakdownId(int breakdownId) {
        this.breakdownId = breakdownId;
    }

    public Date getDate_from() {
        return dateFrom;
    }

    public void setDate_from(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Optional<Date> getDate_to() {
        return dateTo;
    }

    public void setDate_to(Date dateTo) {
        this.dateTo = Optional.ofNullable(dateTo);
    }

    public int getMachine() {
        return machineId;
    }

    public void setMachine(int machineId) {
        this.machineId = machineId;
    }
}
