package com.portlogix.model;

public class Facility {

    private int facilityId;
    private String facilityName;
    private String location;
    private int capacity;

    // Default constructor
    public Facility() {
    }

    // Parameterized constructor
    public Facility(int facilityId,
                    String facilityName,
                    String location,
                    int capacity) {

        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.location = location;
        this.capacity = capacity;
    }

    // Getters and Setters

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // toString method
    @Override
    public String toString() {

        return "Facility {" +
                "ID = " + facilityId +
                ", Name = '" + facilityName + '\'' +
                ", Location = '" + location + '\'' +
                ", Capacity = " + capacity +
                '}';
    }
}