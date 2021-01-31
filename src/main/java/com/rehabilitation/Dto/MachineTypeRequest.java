package com.rehabilitation.Dto;

public class MachineTypeRequest {
    private String name;

    public MachineTypeRequest() {
    }

    public MachineTypeRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
