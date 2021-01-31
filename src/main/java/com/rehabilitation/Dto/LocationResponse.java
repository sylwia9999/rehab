package com.rehabilitation.Dto;

public class LocationResponse {
    private int locationId;
    private String city;
    private String address;

    public LocationResponse() {
    }

    public LocationResponse(int locationId, String city, String address) {
        this.locationId = locationId;
        this.city = city;
        this.address = address;
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
}
