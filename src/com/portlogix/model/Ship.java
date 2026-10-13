package com.portlogix.model;

public class Ship {

    private int shipId;
    private String shipName;
    private String shipCode;
    private double capacity;
    private String status;

    // Default constructor
    public Ship() {
    }

    // Parameterized constructor
    public Ship(int shipId,
                String shipName,
                String shipCode,
                double capacity,
                String status) {

        this.shipId = shipId;
        this.shipName = shipName;
        this.shipCode = shipCode;
        this.capacity = capacity;
        this.status = status;
    }

    // Getters and Setters

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {

        return "Ship {" +
                "ID = " + shipId +
                ", Name = '" + shipName + '\'' +
                ", Code = '" + shipCode + '\'' +
                ", Capacity = " + capacity +
                ", Status = '" + status + '\'' +
                '}';
    }
}