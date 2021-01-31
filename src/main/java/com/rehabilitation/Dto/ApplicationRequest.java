package com.rehabilitation.Dto;

public class ApplicationRequest {
    private int treatmentTypeId;
    private int machineTypeId;

    public ApplicationRequest() {
    }

    public ApplicationRequest(int treatmentTypeId, int machineTypeId) {
        this.treatmentTypeId = treatmentTypeId;
        this.machineTypeId = machineTypeId;
    }

    public int getTreatmentTypeId() {
        return treatmentTypeId;
    }

    public void setTreatmentTypeId(int treatmentTypeId) {
        this.treatmentTypeId = treatmentTypeId;
    }

    public int getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(int machineTypeId) {
        this.machineTypeId = machineTypeId;
    }
}
