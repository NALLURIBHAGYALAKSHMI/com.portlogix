package com.portlogix.service;

import com.portlogix.model.Ship;
import com.portlogix.repository.ShipRepository;

import java.util.List;

public class ShipService {

    private final ShipRepository repository;

    public ShipService() {
        repository = new ShipRepository();
    }

    // Add ship
    public boolean addShip(Ship ship) {

        if (ship == null) {
            System.out.println("Ship cannot be null.");
            return false;
        }

        if (ship.getShipName() == null ||
            ship.getShipName().trim().isEmpty()) {

            System.out.println("Ship name is required.");
            return false;
        }

        if (ship.getShipCode() == null ||
            ship.getShipCode().trim().isEmpty()) {

            System.out.println("Ship code is required.");
            return false;
        }

        if (ship.getCapacity() <= 0) {
            System.out.println("Ship capacity must be greater than 0.");
            return false;
        }

        return repository.addShip(ship);
    }

    // Find ship
    public Ship findShip(int shipId) {

        return repository.findById(shipId);
    }

    // Get all ships
    public List<Ship> getAllShips() {

        return repository.getAllShips();
    }

    // Update ship
    public boolean updateShip(Ship ship) {

        if (ship == null) {
            System.out.println("Ship cannot be null.");
            return false;
        }

        return repository.updateShip(ship);
    }

    // Delete ship
    public boolean deleteShip(int shipId) {

        return repository.deleteShip(shipId);
    }

    // Display all ships
    public void displayShips() {

        List<Ship> ships = repository.getAllShips();

        if (ships.isEmpty()) {

            System.out.println("No ships found.");
            return;
        }

        System.out.println("\n========== SHIP LIST ==========");

        for (Ship ship : ships) {

            System.out.println(ship);
        }

        System.out.println("===============================");
    }
}