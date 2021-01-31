package com.rehabilitation.Dto;

public class TreatmentTypeResponse {
    private int treatmentTypeId;
    private String name;

    public TreatmentTypeResponse() {
    }

    public TreatmentTypeResponse(int treatmentTypeId, String name) {
        this.treatmentTypeId = treatmentTypeId;
        this.name = name;
    }

    public int getTreatment_type_id() {
        return treatmentTypeId;
    }

    public void setTreatment_type_id(int treatmentTypeId) {
        this.treatmentTypeId = treatmentTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
