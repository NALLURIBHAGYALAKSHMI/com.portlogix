package com.portlogix.controller;

import com.portlogix.model.Shipment;
import com.portlogix.service.ShipmentService;
import com.portlogix.config.ConsoleInput;
import java.util.List;
import java.util.Scanner;

public class ShipmentController {

    private final ShipmentService service;
    private final Scanner scanner;

    public ShipmentController() {
        service = new ShipmentService();
        scanner = ConsoleInput.SCANNER;
    }

    // Add shipment
    public void addShipment() {

        System.out.println("\n========== ADD SHIPMENT ==========");

        System.out.print("Enter Shipment ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Container ID: ");
        int containerId = scanner.nextInt();

        System.out.print("Enter Ship ID: ");
        int shipId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Shipment Code: ");
        String code = scanner.nextLine();

        System.out.print("Enter Source: ");
        String source = scanner.nextLine();

        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        Shipment shipment = new Shipment(
                id,
                containerId,
                shipId,
                code,
                source,
                destination,
                status
        );

        boolean success = service.addShipment(shipment);

        if (success) {
            System.out.println("Shipment added successfully!");
        } else {
            System.out.println("Failed to add shipment.");
        }
    }

    // Search shipment
    public void searchShipment() {

        System.out.println("\n========== SEARCH SHIPMENT ==========");

        System.out.print("Enter Shipment ID: ");
        int id = scanner.nextInt();

        Shipment shipment = service.findShipment(id);

        if (shipment != null) {
            System.out.println("\nShipment Found:");
            System.out.println(shipment);
        } else {
            System.out.println("Shipment not found.");
        }
    }

    // Display all shipments
    public void displayShipments() {

        System.out.println("\n========== ALL SHIPMENTS ==========");

        List<Shipment> shipments = service.getAllShipments();

        if (shipments.isEmpty()) {
            System.out.println("No shipments found.");
            return;
        }

        for (Shipment shipment : shipments) {
            System.out.println(shipment);
        }
    }

    // Update shipment
    public void updateShipment() {

        System.out.println("\n========== UPDATE SHIPMENT ==========");

        System.out.print("Enter Shipment ID: ");
        int id = scanner.nextInt();

        Shipment existing = service.findShipment(id);

        if (existing == null) {
            System.out.println("Shipment not found.");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter New Container ID: ");
        int containerId = scanner.nextInt();

        System.out.print("Enter New Ship ID: ");
        int shipId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Shipment Code: ");
        String code = scanner.nextLine();

        System.out.print("Enter New Source: ");
        String source = scanner.nextLine();

        System.out.print("Enter New Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter New Status: ");
        String status = scanner.nextLine();

        Shipment shipment = new Shipment(
                id,
                containerId,
                shipId,
                code,
                source,
                destination,
                status
        );

        boolean success = service.updateShipment(shipment);

        if (success) {
            System.out.println("Shipment updated successfully!");
        } else {
            System.out.println("Failed to update shipment.");
        }
    }

    // Delete shipment
    public void deleteShipment() {

        System.out.println("\n========== DELETE SHIPMENT ==========");

        System.out.print("Enter Shipment ID: ");
        int id = scanner.nextInt();

        boolean success = service.deleteShipment(id);

        if (success) {
            System.out.println("Shipment deleted successfully!");
        } else {
            System.out.println(
                    "Shipment not found or delete failed."
            );
        }
    }
}