package com.portlogix.repository;

import com.portlogix.config.DatabaseConnection;
import com.portlogix.model.Shipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShipmentRepository {

    // Add shipment
    public boolean addShipment(Shipment shipment) {

        String sql = "INSERT INTO shipment " +
                     "(shipment_id, container_id, ship_id, shipment_code, " +
                     "source, destination, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, shipment.getShipmentId());
            statement.setInt(2, shipment.getContainerId());
            statement.setInt(3, shipment.getShipId());
            statement.setString(4, shipment.getShipmentCode());
            statement.setString(5, shipment.getSource());
            statement.setString(6, shipment.getDestination());
            statement.setString(7, shipment.getStatus());

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Error adding shipment: "
                    + e.getMessage());
            return false;
        }
    }

    // Find shipment by ID
    public Shipment findById(int shipmentId) {

        String sql = "SELECT * FROM shipment WHERE shipment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, shipmentId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new Shipment(
                        result.getInt("shipment_id"),
                        result.getInt("container_id"),
                        result.getInt("ship_id"),
                        result.getString("shipment_code"),
                        result.getString("source"),
                        result.getString("destination"),
                        result.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Error finding shipment: "
                    + e.getMessage());
        }

        return null;
    }

    // Get all shipments
    public List<Shipment> getAllShipments() {

        List<Shipment> shipments = new ArrayList<>();

        String sql = "SELECT * FROM shipment";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Shipment shipment = new Shipment(
                        result.getInt("shipment_id"),
                        result.getInt("container_id"),
                        result.getInt("ship_id"),
                        result.getString("shipment_code"),
                        result.getString("source"),
                        result.getString("destination"),
                        result.getString("status")
                );

                shipments.add(shipment);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving shipments: "
                    + e.getMessage());
        }

        return shipments;
    }

    // Update shipment
    public boolean updateShipment(Shipment shipment) {

        String sql = "UPDATE shipment SET " +
                     "container_id = ?, " +
                     "ship_id = ?, " +
                     "shipment_code = ?, " +
                     "source = ?, " +
                     "destination = ?, " +
                     "status = ? " +
                     "WHERE shipment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, shipment.getContainerId());
            statement.setInt(2, shipment.getShipId());
            statement.setString(3, shipment.getShipmentCode());
            statement.setString(4, shipment.getSource());
            statement.setString(5, shipment.getDestination());
            statement.setString(6, shipment.getStatus());
            statement.setInt(7, shipment.getShipmentId());

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error updating shipment: "
                    + e.getMessage());
            return false;
        }
    }

    // Delete shipment
    public boolean deleteShipment(int shipmentId) {

        String sql = "DELETE FROM shipment WHERE shipment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, shipmentId);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error deleting shipment: "
                    + e.getMessage());
            return false;
        }
    }
}