package com.rehabilitation.Dto;

public class TreatmentResponse {
    private int treatmentId;
    private String name;
    private int duration;
    private int order;
    private int repeat_number;
    private int treatmentType;
    private int rehabilitationPlan;

    public TreatmentResponse() {
    }

    public TreatmentResponse(int treatmentId, String name, int duration, int order, int treatmentType, int rehabilitationPlan, int repeat_number) {
        this.treatmentId = treatmentId;
        this.name = name;
        this.duration = duration;
        this.order = order;
        this.treatmentType = treatmentType;
        this.repeat_number = repeat_number;
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

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
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
