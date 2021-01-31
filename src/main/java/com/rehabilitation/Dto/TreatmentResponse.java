package com.rehabilitation.Dto;

import java.util.Optional;

public class TreatmentResponse {
    private int treatmentId;
    private String name;
    private int duration;
    private int order;
    private Optional<Long> user;
    private Optional<Integer> location;
    private Optional<Integer> machine;
    private int treatmentType;
    private int rehabilitationPlanLine;

    public TreatmentResponse() {
    }

    public TreatmentResponse(int treatmentId, String name, int duration, int order, int treatmentType, int rehabilitationPlanLine) {
        this.treatmentId = treatmentId;
        this.name = name;
        this.duration = duration;
        this.order = order;
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

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Optional<Long> getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = Optional.ofNullable(user);
    }

    public Optional<Integer> getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = Optional.of(location);
    }

    public Optional<Integer> getMachine() {
        return machine;
    }

    public void setMachine(int machine) {
        this.machine = Optional.of(machine);
    }

    public int getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(int treatmentType) {
        this.treatmentType = treatmentType;
    }

    public int getRehabilitationPlanLine() {
        return rehabilitationPlanLine;
    }

    public void setRehabilitationPlanLine(int rehabilitationPlanLine) {
        this.rehabilitationPlanLine = rehabilitationPlanLine;
    }
}
