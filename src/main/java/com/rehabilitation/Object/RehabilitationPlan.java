package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
public class RehabilitationPlan {
    @Id
    @GeneratedValue
    @NotNull
    private int planId;
    private Date creationDate;
    private Date startDate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "patientId")
    private Patient patient;
    @OneToMany(mappedBy = "rehabilitationPlan", cascade = CascadeType.ALL)
    private List<Treatment> treatments = new ArrayList<>();

    public RehabilitationPlan() {
    }

    public RehabilitationPlan(int planId, Date creationDate, Date startDate, Patient patient, List<Treatment> treatments) {
        this.planId = planId;
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.patient = patient;
        this.treatments = treatments;
    }

    public List<Treatment> getLines() {
        return treatments;
    }

    public void setLines(List<Treatment> treatments) {
        this.treatments = treatments;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
