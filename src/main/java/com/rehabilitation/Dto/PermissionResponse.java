package com.rehabilitation.Dto;

public class PermissionResponse {
    private int permissionId;
    private int treatmentType;
    private Long worker;

    public PermissionResponse() {
    }

    public PermissionResponse(int permissionId, int treatmentType, Long worker) {
        this.permissionId = permissionId;
        this.treatmentType = treatmentType;
        this.worker = worker;
    }

    public int getPermission_id() {
        return permissionId;
    }

    public void setPermission_id(int permissionId) {
        this.permissionId = permissionId;
    }

    public int getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(int treatmentType) {
        this.treatmentType = treatmentType;
    }

    public Long getWorker() {
        return worker;
    }

    public void setWorker(Long worker) {
        this.worker = worker;
    }
}
