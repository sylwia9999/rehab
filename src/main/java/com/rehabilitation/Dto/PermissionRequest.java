package com.rehabilitation.Dto;

public class PermissionRequest {
    private int treatmentType;
    private Long worker;

    public PermissionRequest() {
    }

    public PermissionRequest(int treatmentType, Long worker) {
        this.treatmentType = treatmentType;
        this.worker = worker;
    }

    public int getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(int treatmentType) {
        this.treatmentType = treatmentType;
    }

    public Long getWorker() {
        return worker;
    }

    public void setWorker(Long worker) {
        this.worker = worker;
    }
}
