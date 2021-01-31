package com.rehabilitation.Dto;

import com.sun.istack.NotNull;

public class UserResponse {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private Boolean enabled;
    private int role_id;

    public UserResponse() {
    }

    public UserResponse(@NotNull Long id, String name, String phoneNumber, String email, String password, Boolean enabled, int role_id) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.role_id = role_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getRole_Id() {
        return role_id;
    }

    public void setRole_Id(int role_id) {
        this.role_id = role_id;
    }
}
