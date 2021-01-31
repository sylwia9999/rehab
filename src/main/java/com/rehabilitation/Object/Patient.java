package com.rehabilitation.Object;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue
    @NotNull
    private int patientId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private String pesel;
    private Time timePreferencesFrom;
    private Time timePreferencesTo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "locationId")
    private Location locationPreferences;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<RehabilitationPlan> plans = new ArrayList<>();

    public Patient() {
    }

    public List<RehabilitationPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<RehabilitationPlan> plans) {
        this.plans = plans;
    }

    public Patient(int patientId, String firstName, String lastName, String email, String address, String phoneNumber, String pesel, Time timePreferencesFrom, Time timePreferencesTo, Location locationPreferences, List<RehabilitationPlan> plans) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.pesel = pesel;
        this.timePreferencesFrom = timePreferencesFrom;
        this.timePreferencesTo = timePreferencesTo;
        this.locationPreferences = locationPreferences;
        this.plans = plans;
    }

    public int getPatient_id() {
        return patientId;
    }

    public void setPatient_id(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Time getTime_preferences_from() {
        return timePreferencesFrom;
    }

    public void setTime_preferences_from(Time timePreferencesFrom) {
        this.timePreferencesFrom = timePreferencesFrom;
    }

    public Time getTime_preferences_to() {
        return timePreferencesTo;
    }

    public void setTime_preferences_to(Time timePreferencesTo) {
        this.timePreferencesTo = timePreferencesTo;
    }

    public Location getLocation_preferences() {
        return locationPreferences;
    }

    public void setLocation_preferences(Location locationPreferences) {
        this.locationPreferences = locationPreferences;
    }
}
