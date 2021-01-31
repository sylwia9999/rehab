package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Application {
    @Id
    @GeneratedValue
    @NotNull
    private int applicationId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "treatmentTypeId")
    private TreatmentType treatmentType;
    @ManyToOne(optional = false)
    @JoinColumn(name = "machineTypeId")
    private MachineType machineType;

    public Application() {
    }

    public Application(int applicationId, TreatmentType treatmentType, MachineType machineType) {
        this.applicationId = applicationId;
        this.treatmentType = treatmentType;
        this.machineType = machineType;
    }

    public int getApplication_id() {
        return applicationId;
    }

    public void setApplication_id(int applicationId) {
        this.applicationId = applicationId;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }
}
