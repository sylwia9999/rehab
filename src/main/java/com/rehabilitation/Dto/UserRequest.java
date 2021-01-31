package com.rehabilitation.Dto;

public class UserRequest {
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private Boolean enabled;
    private int role_id;

    public UserRequest() {
    }

    public UserRequest(String name, String phoneNumber, String email, String password, Boolean enabled, int role_id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.role_id = role_id;
    }

    public UserRequest(String email, String password) {
        this.email = email;
        this.password = password;
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
