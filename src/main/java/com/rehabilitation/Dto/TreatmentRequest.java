package com.rehabilitation.Dto;

public class TreatmentRequest {
    private String name;
    private int duration;
    private int order;
    private Long user;
    private int location;
    private int machine;
    private int treatmentType;
    private int rehabilitationPlanLine;

    public TreatmentRequest() {
    }

    public TreatmentRequest(String name, int duration, int order, Long user, int location, int machine, int treatmentType, int rehabilitationPlanLine) {
        this.name = name;
        this.duration = duration;
        this.order = order;
        this.user = user;
        this.location = location;
        this.machine = machine;
        this.treatmentType = treatmentType;
        this.rehabilitationPlanLine = rehabilitationPlanLine;
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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getMachine() {
        return machine;
    }

    public void setMachine(int machine) {
        this.machine = machine;
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
