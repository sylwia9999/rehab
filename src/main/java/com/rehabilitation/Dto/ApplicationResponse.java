package com.rehabilitation.Dto;

import com.rehabilitation.Object.MachineType;
import com.rehabilitation.Object.TreatmentType;

public class ApplicationResponse {
    private int applicationId;
    private int treatmentTypeId;
    private int machineTypeId;

    public ApplicationResponse() {
    }

    public ApplicationResponse(int applicationId, int treatmentTypeId, int machineTypeId) {
        this.applicationId = applicationId;
        this.treatmentTypeId = treatmentTypeId;
        this.machineTypeId = machineTypeId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
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
