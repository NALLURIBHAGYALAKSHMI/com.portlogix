package com.portlogix.service;

import com.portlogix.model.Shipment;
import com.portlogix.repository.ShipmentRepository;

import java.util.List;

public class ShipmentService {

    private final ShipmentRepository repository;

    public ShipmentService() {
        repository = new ShipmentRepository();
    }

    // Add shipment
    public boolean addShipment(Shipment shipment) {

        if (shipment == null) {
            System.out.println("Shipment cannot be null.");
            return false;
        }

        if (shipment.getShipmentCode() == null ||
            shipment.getShipmentCode().trim().isEmpty()) {

            System.out.println("Shipment code is required.");
            return false;
        }

        if (shipment.getContainerId() <= 0) {
            System.out.println("Invalid container ID.");
            return false;
        }

        if (shipment.getShipId() <= 0) {
            System.out.println("Invalid ship ID.");
            return false;
        }

        return repository.addShipment(shipment);
    }

    // Find shipment
    public Shipment findShipment(int shipmentId) {

        return repository.findById(shipmentId);
    }

    // Get all shipments
    public List<Shipment> getAllShipments() {

        return repository.getAllShipments();
    }

    // Update shipment
    public boolean updateShipment(Shipment shipment) {

        if (shipment == null) {
            System.out.println("Shipment cannot be null.");
            return false;
        }

        return repository.updateShipment(shipment);
    }

    // Delete shipment
    public boolean deleteShipment(int shipmentId) {

        return repository.deleteShipment(shipmentId);
    }

    // Display all shipments
    public void displayShipments() {

        List<Shipment> shipments =
                repository.getAllShipments();

        if (shipments.isEmpty()) {

            System.out.println("No shipments found.");
            return;
        }

        System.out.println("\n========== SHIPMENT LIST ==========");

        for (Shipment shipment : shipments) {

            System.out.println(shipment);
        }

        System.out.println("===================================");
    }
}