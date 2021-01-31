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
    private List<Treatment> treatments = new ArrayList<>();

    public Machine() {
    }

    public Machine(int machineId, String name, Location location, MachineType machineType, List<Breakdown> breakdowns, List<Treatment> treatments) {
        this.machineId = machineId;
        this.name = name;
        this.location = location;
        this.machineType = machineType;
        this.breakdowns = breakdowns;
        this.treatments = treatments;
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

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}

