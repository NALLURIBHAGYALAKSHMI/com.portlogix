package com.portlogix.repository;

import com.portlogix.config.DatabaseConnection;
import com.portlogix.model.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WarehouseRepository {

    // Add warehouse
    public boolean addWarehouse(Warehouse warehouse) {

        String sql = "INSERT INTO warehouse " +
                     "(warehouse_id, warehouse_name, location, capacity, available_space) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, warehouse.getWarehouseId());
            statement.setString(2, warehouse.getWarehouseName());
            statement.setString(3, warehouse.getLocation());
            statement.setInt(4, warehouse.getCapacity());
            statement.setInt(5, warehouse.getAvailableSpace());

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Error adding warehouse: "
                    + e.getMessage());
            return false;
        }
    }

    // Find warehouse by ID
    public Warehouse findById(int warehouseId) {

        String sql = "SELECT * FROM warehouse WHERE warehouse_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, warehouseId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new Warehouse(
                        result.getInt("warehouse_id"),
                        result.getString("warehouse_name"),
                        result.getString("location"),
                        result.getInt("capacity"),
                        result.getInt("available_space")
                );
            }

        } catch (Exception e) {
            System.out.println("Error finding warehouse: "
                    + e.getMessage());
        }

        return null;
    }

    // Get all warehouses
    public List<Warehouse> getAllWarehouses() {

        List<Warehouse> warehouses = new ArrayList<>();

        String sql = "SELECT * FROM warehouse";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Warehouse warehouse = new Warehouse(
                        result.getInt("warehouse_id"),
                        result.getString("warehouse_name"),
                        result.getString("location"),
                        result.getInt("capacity"),
                        result.getInt("available_space")
                );

                warehouses.add(warehouse);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving warehouses: "
                    + e.getMessage());
        }

        return warehouses;
    }

    // Update warehouse
    public boolean updateWarehouse(Warehouse warehouse) {

        String sql = "UPDATE warehouse SET " +
                     "warehouse_name = ?, " +
                     "location = ?, " +
                     "capacity = ?, " +
                     "available_space = ? " +
                     "WHERE warehouse_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, warehouse.getWarehouseName());
            statement.setString(2, warehouse.getLocation());
            statement.setInt(3, warehouse.getCapacity());
            statement.setInt(4, warehouse.getAvailableSpace());
            statement.setInt(5, warehouse.getWarehouseId());

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error updating warehouse: "
                    + e.getMessage());
            return false;
        }
    }

    // Delete warehouse
    public boolean deleteWarehouse(int warehouseId) {

        String sql = "DELETE FROM warehouse WHERE warehouse_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, warehouseId);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error deleting warehouse: "
                    + e.getMessage());
            return false;
        }
    }
}