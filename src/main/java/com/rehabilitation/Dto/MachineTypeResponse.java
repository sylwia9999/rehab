package com.rehabilitation.Dto;

public class MachineTypeResponse {
    private int machineTypeId;
    private String name;

    public MachineTypeResponse() {
    }

    public MachineTypeResponse(int machineTypeId, String name) {
        this.machineTypeId = machineTypeId;
        this.name = name;
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

}
