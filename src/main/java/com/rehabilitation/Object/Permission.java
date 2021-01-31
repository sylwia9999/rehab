package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Permission {
    @Id
    @GeneratedValue
    @NotNull
    private int permissionId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "treatmentTypeId")
    private TreatmentType treatmentType;
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private User worker;

    public Permission() {
    }

    public Permission(int permissionId, TreatmentType treatmentType, User worker) {
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

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }

    public User getWorker() {
        return worker;
    }

    public void setWorker(User worker) {
        this.worker = worker;
    }
}
