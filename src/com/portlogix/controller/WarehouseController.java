package com.portlogix.controller;

import com.portlogix.model.Warehouse;
import com.portlogix.repository.WarehouseRepository;
import com.portlogix.config.ConsoleInput;
import java.util.List;
import java.util.Scanner;

public class WarehouseController {

    private final WarehouseRepository repository;
    private final Scanner scanner;

    public WarehouseController() {
        repository = new WarehouseRepository();
        scanner = ConsoleInput.SCANNER;
    }

    // Add warehouse
    public void addWarehouse() {

        System.out.println("\n========== ADD WAREHOUSE ==========");

        System.out.print("Enter Warehouse ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Warehouse Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Location: ");
        String location = scanner.nextLine();

        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();

        System.out.print("Enter Available Space: ");
        int availableSpace = scanner.nextInt();

        Warehouse warehouse = new Warehouse(
                id,
                name,
                location,
                capacity,
                availableSpace
        );

        boolean success = repository.addWarehouse(warehouse);

        if (success) {
            System.out.println("Warehouse added successfully!");
        } else {
            System.out.println("Failed to add warehouse.");
        }
    }

    // Search warehouse
    public void searchWarehouse() {

        System.out.println("\n========== SEARCH WAREHOUSE ==========");

        System.out.print("Enter Warehouse ID: ");
        int id = scanner.nextInt();

        Warehouse warehouse = repository.findById(id);

        if (warehouse != null) {
            System.out.println("\nWarehouse Found:");
            System.out.println(warehouse);
        } else {
            System.out.println("Warehouse not found.");
        }
    }

    // Display all warehouses
    public void displayWarehouses() {

        System.out.println("\n========== ALL WAREHOUSES ==========");

        List<Warehouse> warehouses =
                repository.getAllWarehouses();

        if (warehouses.isEmpty()) {
            System.out.println("No warehouses found.");
            return;
        }

        for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse);
        }
    }

    // Update warehouse
    public void updateWarehouse() {

        System.out.println("\n========== UPDATE WAREHOUSE ==========");

        System.out.print("Enter Warehouse ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Warehouse existing = repository.findById(id);

        if (existing == null) {
            System.out.println("Warehouse not found.");
            return;
        }

        System.out.print("Enter New Warehouse Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Location: ");
        String location = scanner.nextLine();

        System.out.print("Enter New Capacity: ");
        int capacity = scanner.nextInt();

        System.out.print("Enter New Available Space: ");
        int availableSpace = scanner.nextInt();

        Warehouse warehouse = new Warehouse(
                id,
                name,
                location,
                capacity,
                availableSpace
        );

        boolean success =
                repository.updateWarehouse(warehouse);

        if (success) {
            System.out.println(
                    "Warehouse updated successfully!"
            );
        } else {
            System.out.println(
                    "Failed to update warehouse."
            );
        }
    }

    // Delete warehouse
    public void deleteWarehouse() {

        System.out.println("\n========== DELETE WAREHOUSE ==========");

        System.out.print("Enter Warehouse ID: ");
        int id = scanner.nextInt();

        boolean success =
                repository.deleteWarehouse(id);

        if (success) {
            System.out.println(
                    "Warehouse deleted successfully!"
            );
        } else {
            System.out.println(
                    "Warehouse not found or delete failed."
            );
        }
    }
}