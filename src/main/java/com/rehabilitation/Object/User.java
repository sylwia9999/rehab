package com.rehabilitation.Object;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User{
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    private Long userId;
    private String name;
    @Column(name = "PHONE_NUMBER", unique = true)
    private String phoneNumber;
    @Column(name = "EMAIL_ADDRESS", unique = true)
    private String email;
    private String password;
    private Boolean enabled;
    @ManyToOne(optional = false)
    @JoinColumn(name = "roleId")
    private Role role;
    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<WorkerSchedule> schedules = new ArrayList<>();
    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<Treatment> treatments = new ArrayList<>();
    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<Permission> permissions = new ArrayList<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<WorkerSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<WorkerSchedule> schedules) {
        this.schedules = schedules;
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

    public User() {
    }

    public User(Long userId, String name, String phoneNumber, String email, String password, Boolean enabled, Role role, List<WorkerSchedule> schedules, List<Treatment> treatments, List<Permission> permissions) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.schedules = schedules;
        this.treatments = treatments;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSubscription() {
        return enabled;
    }

    public void setSubscription(Boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}


