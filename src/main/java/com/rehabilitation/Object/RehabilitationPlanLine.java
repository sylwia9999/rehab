package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RehabilitationPlanLine {
    @Id
    @GeneratedValue
    @NotNull
    private int lineId;
    private int repeat_number;
    @ManyToOne(optional = false)
    @JoinColumn(name = "planId")
    private RehabilitationPlan rehabilitationPlan;
    @OneToMany(mappedBy = "rehabilitationPlanLine", cascade = CascadeType.ALL)
    private List<Treatment> treatments = new ArrayList<>();

    public RehabilitationPlanLine() {
    }

    public RehabilitationPlanLine(int lineId, int repeat_number, RehabilitationPlan rehabilitationPlan, List<Treatment> treatments) {
        this.lineId = lineId;
        this.repeat_number = repeat_number;
        this.rehabilitationPlan = rehabilitationPlan;
        this.treatments = treatments;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
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

    public RehabilitationPlan getRehabilitationPlan() {
        return rehabilitationPlan;
    }

    public void setRehabilitationPlan(RehabilitationPlan rehabilitationPlan) {
        this.rehabilitationPlan = rehabilitationPlan;
    }
}
