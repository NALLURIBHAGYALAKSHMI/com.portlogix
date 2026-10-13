package com.portlogix.model;

public class Shipment {

    private int shipmentId;
    private int containerId;
    private int shipId;
    private String shipmentCode;
    private String source;
    private String destination;
    private String status;

    // Default constructor
    public Shipment() {
    }

    // Parameterized constructor
    public Shipment(int shipmentId,
                    int containerId,
                    int shipId,
                    String shipmentCode,
                    String source,
                    String destination,
                    String status) {

        this.shipmentId = shipmentId;
        this.containerId = containerId;
        this.shipId = shipId;
        this.shipmentCode = shipmentCode;
        this.source = source;
        this.destination = destination;
        this.status = status;
    }

    // Getters and Setters

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public int getContainerId() {
        return containerId;
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

        return "Shipment {" +
                "ID = " + shipmentId +
                ", Container ID = " + containerId +
                ", Ship ID = " + shipId +
                ", Code = '" + shipmentCode + '\'' +
                ", Source = '" + source + '\'' +
                ", Destination = '" + destination + '\'' +
                ", Status = '" + status + '\'' +
                '}';
    }
}