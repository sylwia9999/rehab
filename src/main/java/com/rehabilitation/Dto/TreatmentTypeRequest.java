package com.rehabilitation.Dto;

public class TreatmentTypeRequest {
    private String name;

    public TreatmentTypeRequest() {
    }

    public TreatmentTypeRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
