package com.portlogix.controller;

import com.portlogix.model.Ship;
import com.portlogix.service.ShipService;
import com.portlogix.config.ConsoleInput;
import java.util.List;
import java.util.Scanner;

public class ShipController {

    private final ShipService service;
    private final Scanner scanner;

    public ShipController() {
        service = new ShipService();
        scanner = ConsoleInput.SCANNER;
    }

    // Add ship
    public void addShip() {

        System.out.println("\n========== ADD SHIP ==========");

        System.out.print("Enter Ship ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Ship Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Ship Code: ");
        String code = scanner.nextLine();

        System.out.print("Enter Capacity: ");
        double capacity = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        Ship ship = new Ship(
                id,
                name,
                code,
                capacity,
                status
        );

        boolean success = service.addShip(ship);

        if (success) {
            System.out.println("Ship added successfully!");
        } else {
            System.out.println("Failed to add ship.");
        }
    }

    // Search ship
    public void searchShip() {

        System.out.println("\n========== SEARCH SHIP ==========");

        System.out.print("Enter Ship ID: ");
        int id = scanner.nextInt();

        Ship ship = service.findShip(id);

        if (ship != null) {
            System.out.println("\nShip Found:");
            System.out.println(ship);
        } else {
            System.out.println("Ship not found.");
        }
    }

    // Display all ships
    public void displayShips() {

        System.out.println("\n========== ALL SHIPS ==========");

        List<Ship> ships = service.getAllShips();

        if (ships.isEmpty()) {
            System.out.println("No ships found.");
            return;
        }

        for (Ship ship : ships) {
            System.out.println(ship);
        }
    }

    // Update ship
    public void updateShip() {

        System.out.println("\n========== UPDATE SHIP ==========");

        System.out.print("Enter Ship ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Ship existing = service.findShip(id);

        if (existing == null) {
            System.out.println("Ship not found.");
            return;
        }

        System.out.print("Enter New Ship Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Ship Code: ");
        String code = scanner.nextLine();

        System.out.print("Enter New Capacity: ");
        double capacity = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter New Status: ");
        String status = scanner.nextLine();

        Ship ship = new Ship(
                id,
                name,
                code,
                capacity,
                status
        );

        boolean success = service.updateShip(ship);

        if (success) {
            System.out.println("Ship updated successfully!");
        } else {
            System.out.println("Failed to update ship.");
        }
    }

    // Delete ship
    public void deleteShip() {

        System.out.println("\n========== DELETE SHIP ==========");

        System.out.print("Enter Ship ID: ");
        int id = scanner.nextInt();

        boolean success = service.deleteShip(id);

        if (success) {
            System.out.println("Ship deleted successfully!");
        } else {
            System.out.println(
                    "Ship not found or delete failed."
            );
        }
    }
}