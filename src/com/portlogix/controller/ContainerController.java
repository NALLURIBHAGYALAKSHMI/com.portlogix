package com.portlogix.controller;

import com.portlogix.model.Container;
import com.portlogix.service.ContainerService;
import com.portlogix.config.ConsoleInput;
import java.util.List;
import java.util.Scanner;

public class ContainerController {

    private final ContainerService service;
    private final Scanner scanner;

    public ContainerController() {
        service = new ContainerService();
        scanner = ConsoleInput.SCANNER;
    }

    // Add container
    public void addContainer() {

        System.out.println("\n========== ADD CONTAINER ==========");

        System.out.print("Enter Container ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Container Code: ");
        String code = scanner.nextLine();

        System.out.print("Enter Cargo Description: ");
        String cargo = scanner.nextLine();

        System.out.print("Enter Weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        Container container = new Container(
                id,
                code,
                cargo,
                weight,
                status
        );

        boolean success = service.addContainer(container);

        if (success) {
            System.out.println("Container added successfully!");
        } else {
            System.out.println("Failed to add container.");
        }
    }

    // Search container
    public void searchContainer() {

        System.out.println("\n========== SEARCH CONTAINER ==========");

        System.out.print("Enter Container ID: ");
        int id = scanner.nextInt();

        Container container = service.findContainer(id);

        if (container != null) {
            System.out.println("\nContainer Found:");
            System.out.println(container);
        } else {
            System.out.println("Container not found.");
        }
    }

    // Display all containers
    public void displayContainers() {

        System.out.println("\n========== ALL CONTAINERS ==========");

        List<Container> containers =
                service.getAllContainers();

        if (containers.isEmpty()) {
            System.out.println("No containers found.");
            return;
        }

        for (Container container : containers) {
            System.out.println(container);
        }
    }

    // Update container
    public void updateContainer() {

        System.out.println("\n========== UPDATE CONTAINER ==========");

        System.out.print("Enter Container ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Container existing = service.findContainer(id);

        if (existing == null) {
            System.out.println("Container not found.");
            return;
        }

        System.out.print("Enter New Container Code: ");
        String code = scanner.nextLine();

        System.out.print("Enter New Cargo Description: ");
        String cargo = scanner.nextLine();

        System.out.print("Enter New Weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter New Status: ");
        String status = scanner.nextLine();

        Container container = new Container(
                id,
                code,
                cargo,
                weight,
                status
        );

        boolean success =
                service.updateContainer(container);

        if (success) {
            System.out.println("Container updated successfully!");
        } else {
            System.out.println("Failed to update container.");
        }
    }

    // Delete container
    public void deleteContainer() {

        System.out.println("\n========== DELETE CONTAINER ==========");

        System.out.print("Enter Container ID: ");
        int id = scanner.nextInt();

        boolean success =
                service.deleteContainer(id);

        if (success) {
            System.out.println("Container deleted successfully!");
        } else {
            System.out.println("Container not found or delete failed.");
        }
    }
}