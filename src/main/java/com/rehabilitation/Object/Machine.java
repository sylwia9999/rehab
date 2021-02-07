package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Machine {
    @Id
    @GeneratedValue
    @NotNull
    private int machineId;
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "locationId")
    private Location location;
    @ManyToOne(optional = false)
    @JoinColumn(name = "machineTypeId")
    private MachineType machineType;
    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL)
    private List<Breakdown> breakdowns = new ArrayList<>();
    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL)
    private List<TreatmentSchedule> treatmentSchedules = new ArrayList<>();

    public Machine() {
    }

    public Machine(int machineId, String name, Location location, MachineType machineType, List<Breakdown> breakdowns, List<TreatmentSchedule> treatmentSchedules) {
        this.machineId = machineId;
        this.name = name;
        this.location = location;
        this.machineType = machineType;
        this.breakdowns = breakdowns;
        this.treatmentSchedules = treatmentSchedules;
    }

    public int getMachine_id() {
        return machineId;
    }

    public void setMachine_id(int machineId) {
        this.machineId = machineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    public List<Breakdown> getBreakdowns() {
        return breakdowns;
    }

    public void setBreakdowns(List<Breakdown> breakdowns) {
        this.breakdowns = breakdowns;
    }

    public List<TreatmentSchedule> getTreatmentSchedules() {
        return treatmentSchedules;
    }

    public void setTreatmentSchedules(List<TreatmentSchedule> treatmentSchedules) {
        this.treatmentSchedules = treatmentSchedules;
    }
}

