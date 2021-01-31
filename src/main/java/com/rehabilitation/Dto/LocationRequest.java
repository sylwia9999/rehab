package com.rehabilitation.Dto;

public class LocationRequest {
    private String city;
    private String address;

    public LocationRequest() {
    }

    public LocationRequest(String city, String address) {
        this.city = city;
        this.address = address;
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

}
