package com.portlogix.model;

public class Warehouse {

    private int warehouseId;
    private String warehouseName;
    private String location;
    private int capacity;
    private int availableSpace;

    // Default constructor
    public Warehouse() {
    }

    // Parameterized constructor
    public Warehouse(int warehouseId,
                     String warehouseName,
                     String location,
                     int capacity,
                     int availableSpace) {

        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.location = location;
        this.capacity = capacity;
        this.availableSpace = availableSpace;
    }

    // Getters and Setters

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
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

    public int getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }

    // toString method
    @Override
    public String toString() {

        return "Warehouse {" +
                "ID = " + warehouseId +
                ", Name = '" + warehouseName + '\'' +
                ", Location = '" + location + '\'' +
                ", Capacity = " + capacity +
                ", Available Space = " + availableSpace +
                '}';
    }
}