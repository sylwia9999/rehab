package com.rehabilitation.Dto;

public class RoleResponse {
    private int role_id;
    private String name;

    public RoleResponse() {
    }

    public RoleResponse(int role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
