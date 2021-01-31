package com.rehabilitation.Dto;

public class RehabilitationPlanLineResponse {
    private int lineId;
    private int repeat_number;
    private int rehabilitationPlan;

    public RehabilitationPlanLineResponse() {
    }

    public RehabilitationPlanLineResponse(int lineId, int repeat_number, int rehabilitationPlan) {
        this.lineId = lineId;
        this.repeat_number = repeat_number;
        this.rehabilitationPlan = rehabilitationPlan;
    }

    public int getLine_id() {
        return lineId;
    }

    public void setLine_id(int lineId) {
        this.lineId = lineId;
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
