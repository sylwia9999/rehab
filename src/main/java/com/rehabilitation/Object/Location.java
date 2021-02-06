package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue
    @NotNull
    private int locationId;
    private String city;
    private String address;
    @OneToMany(mappedBy = "locationPreferences", cascade = CascadeType.ALL)
    private List<Patient> patients = new ArrayList<>();
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<User> workers = new ArrayList<>();
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Machine> machines= new ArrayList<>();
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<TreatmentSchedule> treatments = new ArrayList<>();

    public Location() {
    }

    public Location(int locationId, String city, String address, List<Patient> patients, List<User> workers, List<Machine> machines, List<TreatmentSchedule> treatments) {
        this.locationId = locationId;
        this.city = city;
        this.address = address;
        this.patients = patients;
        this.workers = workers;
        this.machines = machines;
        this.treatments = treatments;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<User> getWorkers() {
        return workers;
    }

    public void setWorkers(List<User> workers) {
        this.workers = workers;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public List<TreatmentSchedule> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<TreatmentSchedule> treatments) {
        this.treatments = treatments;
    }
}
