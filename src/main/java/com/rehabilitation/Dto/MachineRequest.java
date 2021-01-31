package com.rehabilitation.Dto;

public class MachineRequest {
    private String name;
    private int locationId;
    private int machineTypeId;

    public MachineRequest() {
    }

    public MachineRequest(int machineTypeId, String name, int locationId) {
        this.name = name;
        this.locationId = locationId;
        this.machineTypeId = machineTypeId;
    }

    public int getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(int machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


}
