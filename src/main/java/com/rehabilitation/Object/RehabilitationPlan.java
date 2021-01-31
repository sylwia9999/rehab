package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class RehabilitationPlan {
    @Id
    @GeneratedValue
    @NotNull
    private int planId;
    private Date creationDate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "patientId")
    private Patient patient;
    @OneToMany(mappedBy = "rehabilitationPlan", cascade = CascadeType.ALL)
    private List<RehabilitationPlanLine> lines = new ArrayList<>();

    public RehabilitationPlan() {
    }

    public RehabilitationPlan(int planId, Date creationDate, Patient patient, List<RehabilitationPlanLine> lines) {
        this.planId = planId;
        this.creationDate = creationDate;
        this.patient = patient;
        this.lines = lines;
    }

    public List<RehabilitationPlanLine> getLines() {
        return lines;
    }

    public void setLines(List<RehabilitationPlanLine> lines) {
        this.lines = lines;
    }

    public int getPlan_id() {
        return planId;
    }

    public void setPlan_id(int planId) {
        this.planId = planId;
    }

    public Date getCreation_date() {
        return creationDate;
    }

    public void setCreation_date(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
