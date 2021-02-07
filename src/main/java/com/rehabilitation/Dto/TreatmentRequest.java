package com.rehabilitation.Dto;

public class TreatmentRequest {
    private String name;
    private int duration;
    private int order;
    private int repeat_number;
    private int treatmentType;
    private int rehabilitationPlan;

    public TreatmentRequest() {
    }

    public TreatmentRequest(String name, int duration, int order, int repeat_number, int treatmentType, int rehabilitationPlan) {
        this.name = name;
        this.duration = duration;
        this.order = order;
        this.repeat_number = repeat_number;
        this.treatmentType = treatmentType;
        this.rehabilitationPlan = rehabilitationPlan;
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


    public int getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(int treatmentType) {
        this.treatmentType = treatmentType;
    }

    public int getRehabilitationPlan() {
        return rehabilitationPlan;
    }

    public void setRehabilitationPlan(int rehabilitationPlan) {
        this.rehabilitationPlan = rehabilitationPlan;
    }

    public int getRepeat_number() {
        return repeat_number;
    }

    public void setRepeat_number(int repeat_number) {
        this.repeat_number = repeat_number;
    }
}
