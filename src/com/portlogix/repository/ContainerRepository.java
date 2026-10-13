package com.portlogix.repository;

import com.portlogix.config.DatabaseConnection;
import com.portlogix.model.Container;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContainerRepository {

    // Add container
    public boolean addContainer(Container container) {

        String sql = "INSERT INTO container " +
                     "(container_id, container_code, cargo_description, weight, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, container.getContainerId());
            statement.setString(2, container.getContainerCode());
            statement.setString(3, container.getCargoDescription());
            statement.setDouble(4, container.getWeight());
            statement.setString(5, container.getStatus());

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Error adding container: " + e.getMessage());
            return false;
        }
    }

    // Find container by ID
    public Container findById(int containerId) {

        String sql = "SELECT * FROM container WHERE container_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, containerId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new Container(
                        result.getInt("container_id"),
                        result.getString("container_code"),
                        result.getString("cargo_description"),
                        result.getDouble("weight"),
                        result.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Error finding container: " + e.getMessage());
        }

        return null;
    }

    // Get all containers
    public List<Container> getAllContainers() {

        List<Container> containers = new ArrayList<>();

        String sql = "SELECT * FROM container";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Container container = new Container(
                        result.getInt("container_id"),
                        result.getString("container_code"),
                        result.getString("cargo_description"),
                        result.getDouble("weight"),
                        result.getString("status")
                );

                containers.add(container);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving containers: " + e.getMessage());
        }

        return containers;
    }

    // Update container
    public boolean updateContainer(Container container) {

        String sql = "UPDATE container SET " +
                     "container_code = ?, " +
                     "cargo_description = ?, " +
                     "weight = ?, " +
                     "status = ? " +
                     "WHERE container_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, container.getContainerCode());
            statement.setString(2, container.getCargoDescription());
            statement.setDouble(3, container.getWeight());
            statement.setString(4, container.getStatus());
            statement.setInt(5, container.getContainerId());

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error updating container: " + e.getMessage());
            return false;
        }
    }

    // Delete container
    public boolean deleteContainer(int containerId) {

        String sql = "DELETE FROM container WHERE container_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, containerId);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error deleting container: " + e.getMessage());
            return false;
        }
    }
}