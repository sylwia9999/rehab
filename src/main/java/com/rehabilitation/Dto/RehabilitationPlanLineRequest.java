package com.rehabilitation.Dto;

public class RehabilitationPlanLineRequest {
    private int repeat_number;
    private int rehabilitationPlan;

    public RehabilitationPlanLineRequest() {
    }

    public RehabilitationPlanLineRequest(int repeat_number, int rehabilitationPlan) {
        this.repeat_number = repeat_number;
        this.rehabilitationPlan = rehabilitationPlan;
    }

    public int getRepeat_number() {
        return repeat_number;
    }

    public void setRepeat_number(int repeat_number) {
        this.repeat_number = repeat_number;
    }

    public int getRehabilitationPlan() {
        return rehabilitationPlan;
    }

    public void setRehabilitationPlan(int rehabilitationPlan) {
        this.rehabilitationPlan = rehabilitationPlan;
    }
}
