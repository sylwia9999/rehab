package com.rehabilitation.Dto;

public class MachineResponse {
    private int machineId;
    private String name;
    private int locationId;
    private int machineTypeId;

    public MachineResponse() {
    }

    public MachineResponse(int machineId, String name, int locationId, int machineTypeId) {
        this.machineId = machineId;
        this.name = name;
        this.locationId = locationId;
        this.machineTypeId = machineTypeId;
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

    public int getLocation() {
        return locationId;
    }

    public void setLocation(int locationId) {
        this.locationId = locationId;
    }

    public int getMachineType() {
        return machineTypeId;
    }

    public void setMachineType(int machineTypeId) {
        this.machineTypeId = machineTypeId;
    }
}
