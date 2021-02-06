package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Treatment {
    @Id
    @GeneratedValue
    @NotNull
    private int treatmentId;
    @Column(name="[name]")
    private String name;
    private int duration;
    @Column(name="[order]")
    private int order;
    @OneToOne(mappedBy = "treatment")
    private TreatmentSchedule treatmentSchedule;
    @ManyToOne(optional = false)
    @JoinColumn(name = "treatmentTypeId")
    private TreatmentType treatmentType;
    private int repeat_number;
    @ManyToOne(optional = false)
    @JoinColumn(name = "planId")
    private RehabilitationPlan rehabilitationPlan;

    public Treatment() {
    }

    public Treatment(int treatmentId, String name, int duration, int order, TreatmentSchedule treatmentSchedule, int repeat_number, TreatmentType treatmentType, RehabilitationPlan rehabilitationPlan) {
        this.treatmentId = treatmentId;
        this.name = name;
        this.duration = duration;
        this.repeat_number = repeat_number;
        this.order = order;
        this.treatmentSchedule = treatmentSchedule;
        this.treatmentType = treatmentType;
        this.rehabilitationPlan = rehabilitationPlan;
    }

    public int getTreatment_id() {
        return treatmentId;
    }

    public void setTreatment_id(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public TreatmentSchedule getTreatmentSchedule() {
        return treatmentSchedule;
    }

    public void setTreatmentSchedule(TreatmentSchedule treatmentSchedule) {
        this.treatmentSchedule = treatmentSchedule;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }

    public RehabilitationPlan getRehabilitationPlanLine() {
        return rehabilitationPlan;
    }

    public void setRehabilitationPlan(RehabilitationPlan rehabilitationPlan) {
        this.rehabilitationPlan = rehabilitationPlan;
    }

    public int getRepeat_number() {
        return repeat_number;
    }

    public void setRepeat_number(int repeat_number) {
        this.repeat_number = repeat_number;
    }
}

