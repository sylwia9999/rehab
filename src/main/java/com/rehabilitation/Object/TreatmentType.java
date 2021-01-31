package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TreatmentType {
    @Id
    @GeneratedValue
    @NotNull
    private int treatmentTypeId;
    private String name;
    @OneToMany(mappedBy = "treatmentType", cascade = CascadeType.ALL)
    private List<Treatment> treatments = new ArrayList<>();
    @OneToMany(mappedBy = "treatmentType", cascade = CascadeType.ALL)
    private List<Permission> permissions = new ArrayList<>();
    @OneToMany(mappedBy = "treatmentType", cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();

    public TreatmentType() {
    }

    public TreatmentType(int treatmentTypeId, String name, List<Treatment> treatments, List<Permission> permissions, List<Application> applications) {
        this.treatmentTypeId = treatmentTypeId;
        this.name = name;
        this.treatments = treatments;
        this.permissions = permissions;
        this.applications = applications;
    }

    public int getTreatment_type_id() {
        return treatmentTypeId;
    }

    public void setTreatment_type_id(int treatmentTypeId) {
        this.treatmentTypeId = treatmentTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
