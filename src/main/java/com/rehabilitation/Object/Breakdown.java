package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Breakdown {
    @Id
    @GeneratedValue
    @NotNull
    private int breakdownId;
    private Date dateFrom;
    private Date dateTo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "machineId")
    private Machine machine;

    public Breakdown() {
    }

    public Breakdown(int breakdownId, Date dateFrom, Date dateTo, Machine machine) {
        this.breakdownId = breakdownId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.machine = machine;
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

    public Date getDate_to() {
        return dateTo;
    }

    public void setDate_to(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}
