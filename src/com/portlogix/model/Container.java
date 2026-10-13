package com.portlogix.model;

public class Container {

    private int containerId;
    private String containerCode;
    private String cargoDescription;
    private double weight;
    private String status;

    // Default constructor
    public Container() {
    }

    // Parameterized constructor
    public Container(int containerId,
                     String containerCode,
                     String cargoDescription,
                     double weight,
                     String status) {

        this.containerId = containerId;
        this.containerCode = containerCode;
        this.cargoDescription = cargoDescription;
        this.weight = weight;
        this.status = status;
    }

    // Getters and Setters

    public int getContainerId() {
        return containerId;
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode;
    }

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

        return "Container {" +
                "ID = " + containerId +
                ", Code = '" + containerCode + '\'' +
                ", Cargo = '" + cargoDescription + '\'' +
                ", Weight = " + weight +
                ", Status = '" + status + '\'' +
                '}';
    }
}