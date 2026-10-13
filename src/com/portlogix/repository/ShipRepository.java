package com.portlogix.repository;

import com.portlogix.config.DatabaseConnection;
import com.portlogix.model.Ship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShipRepository {

    // Add ship
    public boolean addShip(Ship ship) {

        String sql = "INSERT INTO ship " +
                     "(ship_id, ship_name, ship_code, capacity, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, ship.getShipId());
            statement.setString(2, ship.getShipName());
            statement.setString(3, ship.getShipCode());
            statement.setDouble(4, ship.getCapacity());
            statement.setString(5, ship.getStatus());

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Error adding ship: " + e.getMessage());
            return false;
        }
    }

    // Find ship by ID
    public Ship findById(int shipId) {

        String sql = "SELECT * FROM ship WHERE ship_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, shipId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new Ship(
                        result.getInt("ship_id"),
                        result.getString("ship_name"),
                        result.getString("ship_code"),
                        result.getDouble("capacity"),
                        result.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Error finding ship: " + e.getMessage());
        }

        return null;
    }

    // Get all ships
    public List<Ship> getAllShips() {

        List<Ship> ships = new ArrayList<>();

        String sql = "SELECT * FROM ship";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Ship ship = new Ship(
                        result.getInt("ship_id"),
                        result.getString("ship_name"),
                        result.getString("ship_code"),
                        result.getDouble("capacity"),
                        result.getString("status")
                );

                ships.add(ship);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving ships: "
                    + e.getMessage());
        }

        return ships;
    }

    // Update ship
    public boolean updateShip(Ship ship) {

        String sql = "UPDATE ship SET " +
                     "ship_name = ?, " +
                     "ship_code = ?, " +
                     "capacity = ?, " +
                     "status = ? " +
                     "WHERE ship_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, ship.getShipName());
            statement.setString(2, ship.getShipCode());
            statement.setDouble(3, ship.getCapacity());
            statement.setString(4, ship.getStatus());
            statement.setInt(5, ship.getShipId());

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error updating ship: "
                    + e.getMessage());
            return false;
        }
    }

    // Delete ship
    public boolean deleteShip(int shipId) {

        String sql = "DELETE FROM ship WHERE ship_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, shipId);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error deleting ship: "
                    + e.getMessage());
            return false;
        }
    }
}