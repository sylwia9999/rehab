package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class TreatmentSchedule {
    @Id
    @GeneratedValue
    @NotNull
    private int treatmentScheduleId;
    private Date date;
    private Time timeFrom;
    private Time timeTo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatmentId")
    private Treatment treatment;

    public TreatmentSchedule() {
    }

    public TreatmentSchedule(int treatmentScheduleId, Date date, Time timeFrom, Time timeTo, Treatment treatment) {
        this.treatmentScheduleId = treatmentScheduleId;
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.treatment = treatment;
    }

    public int getTreatment_schedule_id() {
        return treatmentScheduleId;
    }

    public void setTreatment_schedule_id(int treatmentScheduleId) {
        this.treatmentScheduleId = treatmentScheduleId;
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

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
