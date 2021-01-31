package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Treatment {
    @Id
    @GeneratedValue
    @NotNull
    private int treatmentId;
    private String name;
    private int duration;
    private int order;
    @OneToOne(mappedBy = "treatment")
    private TreatmentSchedule treatmentSchedule;
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private User worker;
    @ManyToOne(optional = false)
    @JoinColumn(name = "locationId")
    private Location location;
    @ManyToOne(optional = false)
    @JoinColumn(name = "machineId")
    private Machine machine;
    @ManyToOne(optional = false)
    @JoinColumn(name = "treatmentTypeId")
    private TreatmentType treatmentType;
    @ManyToOne(optional = false)
    @JoinColumn(name = "lineId")
    private RehabilitationPlanLine rehabilitationPlanLine;

    public Treatment() {
    }

    public Treatment(int treatmentId, String name, int duration, int order, TreatmentSchedule treatmentSchedule, User worker, Location location, Machine machine, TreatmentType treatmentType, RehabilitationPlanLine rehabilitationPlanLine) {
        this.treatmentId = treatmentId;
        this.name = name;
        this.duration = duration;
        this.order = order;
        this.treatmentSchedule = treatmentSchedule;
        this.worker = worker;
        this.location = location;
        this.machine = machine;
        this.treatmentType = treatmentType;
        this.rehabilitationPlanLine = rehabilitationPlanLine;
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

    public User getUser() {
        return worker;
    }

    public void setUser(User worker) {
        this.worker = worker;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }

    public RehabilitationPlanLine getRehabilitationPlanLine() {
        return rehabilitationPlanLine;
    }

    public void setRehabilitationPlanLine(RehabilitationPlanLine rehabilitationPlanLine) {
        this.rehabilitationPlanLine = rehabilitationPlanLine;
    }
}

