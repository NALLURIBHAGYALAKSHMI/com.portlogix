package main;

import java.util.Scanner;

import com.portlogix.config.ConsoleInput;
import com.portlogix.controller.ShipController;
import com.portlogix.controller.ContainerController;
import com.portlogix.controller.ShipmentController;
import com.portlogix.controller.WarehouseController;
import com.portlogix.controller.DSAController;

public class PortLogixMain {

    public static void main(String[] args) {

        Scanner scanner = ConsoleInput.SCANNER;

        ShipController shipController =
                new ShipController();

        ContainerController containerController =
                new ContainerController();

        ShipmentController shipmentController =
                new ShipmentController();

        WarehouseController warehouseController =
                new WarehouseController();

        DSAController dsaController =
                new DSAController();

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n========================================");
            System.out.println("       PORTLOGIX MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Ship Management");
            System.out.println("2. Container Management");
            System.out.println("3. Shipment Management");
            System.out.println("4. Warehouse Management");
            System.out.println("5. Facility Management");
            System.out.println("6. Inspection Management");
            System.out.println("7. DSA Algorithms");
            System.out.println("8. Reports and Analytics");
            System.out.println("0. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    shipMenu(scanner, shipController);
                    break;

                case 2:
                    containerMenu(scanner, containerController);
                    break;

                case 3:
                    shipmentMenu(scanner, shipmentController);
                    break;

                case 4:
                    warehouseMenu(scanner, warehouseController);
                    break;

                case 5:
                    System.out.println(
                        "Facility management is not connected yet."
                    );
                    break;

                case 6:
                    System.out.println(
                        "Inspection management is not connected yet."
                    );
                    break;

                case 7:
                    dsaController.showMenu();
                    break;

                case 8:
                    System.out.println(
                        "Reports module is not connected yet."
                    );
                    break;

                case 0:
                    System.out.println(
                        "Thank you for using PortLogix!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("Application closed.");
    }

    private static void shipMenu(
            Scanner scanner,
            ShipController controller) {

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n--- SHIP MANAGEMENT ---");
            System.out.println("1. Add Ship");
            System.out.println("2. Display Ships");
            System.out.println("3. Search Ship");
            System.out.println("4. Update Ship");
            System.out.println("5. Delete Ship");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    controller.addShip();
                    break;
                case 2:
                    controller.displayShips();
                    break;
                case 3:
                    controller.searchShip();
                    break;
                case 4:
                    controller.updateShip();
                    break;
                case 5:
                    controller.deleteShip();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void containerMenu(
            Scanner scanner,
            ContainerController controller) {

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n--- CONTAINER MANAGEMENT ---");
            System.out.println("1. Add Container");
            System.out.println("2. Display Containers");
            System.out.println("3. Search Container");
            System.out.println("4. Update Container");
            System.out.println("5. Delete Container");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    controller.addContainer();
                    break;
                case 2:
                    controller.displayContainers();
                    break;
                case 3:
                    controller.searchContainer();
                    break;
                case 4:
                    controller.updateContainer();
                    break;
                case 5:
                    controller.deleteContainer();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void shipmentMenu(
            Scanner scanner,
            ShipmentController controller) {

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n--- SHIPMENT MANAGEMENT ---");
            System.out.println("1. Add Shipment");
            System.out.println("2. Display Shipments");
            System.out.println("3. Search Shipment");
            System.out.println("4. Update Shipment");
            System.out.println("5. Delete Shipment");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    controller.addShipment();
                    break;
                case 2:
                    controller.displayShipments();
                    break;
                case 3:
                    controller.searchShipment();
                    break;
                case 4:
                    controller.updateShipment();
                    break;
                case 5:
                    controller.deleteShipment();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void warehouseMenu(
            Scanner scanner,
            WarehouseController controller) {

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n--- WAREHOUSE MANAGEMENT ---");
            System.out.println("1. Add Warehouse");
            System.out.println("2. Display Warehouses");
            System.out.println("3. Search Warehouse");
            System.out.println("4. Update Warehouse");
            System.out.println("5. Delete Warehouse");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    controller.addWarehouse();
                    break;
                case 2:
                    controller.displayWarehouses();
                    break;
                case 3:
                    controller.searchWarehouse();
                    break;
                case 4:
                    controller.updateWarehouse();
                    break;
                case 5:
                    controller.deleteWarehouse();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}