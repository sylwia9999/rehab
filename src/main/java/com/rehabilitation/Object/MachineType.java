package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MachineType {
    @Id
    @GeneratedValue
    @NotNull
    private int machineTypeId;
    private String name;
    @OneToMany(mappedBy = "machineType", cascade = CascadeType.ALL)
    private List<Machine> machines = new ArrayList<>();
    @OneToMany(mappedBy = "machineType", cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();

    public MachineType() {
    }

    public MachineType(int machineTypeId, String name, List<Machine> machines, List<Application> applications) {
        this.machineTypeId = machineTypeId;
        this.name = name;
        this.machines = machines;
        this.applications = applications;
    }

    public int getMachine_type_id() {
        return machineTypeId;
    }

    public void setMachine_type_id(int machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
