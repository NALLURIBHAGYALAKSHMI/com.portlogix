package com.portlogix.repository;

import com.portlogix.config.DatabaseConnection;
import com.portlogix.model.Facility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository {

    // Add facility
    public boolean addFacility(Facility facility) {

        String sql = "INSERT INTO facility " +
                     "(facility_id, facility_name, location, capacity) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, facility.getFacilityId());
            statement.setString(2, facility.getFacilityName());
            statement.setString(3, facility.getLocation());
            statement.setInt(4, facility.getCapacity());

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Error adding facility: " + e.getMessage());
            return false;
        }
    }

    // Find facility by ID
    public Facility findById(int facilityId) {

        String sql = "SELECT * FROM facility WHERE facility_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, facilityId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new Facility(
                        result.getInt("facility_id"),
                        result.getString("facility_name"),
                        result.getString("location"),
                        result.getInt("capacity")
                );
            }

        } catch (Exception e) {
            System.out.println("Error finding facility: " + e.getMessage());
        }

        return null;
    }

    // Get all facilities
    public List<Facility> getAllFacilities() {

        List<Facility> facilities = new ArrayList<>();

        String sql = "SELECT * FROM facility";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Facility facility = new Facility(
                        result.getInt("facility_id"),
                        result.getString("facility_name"),
                        result.getString("location"),
                        result.getInt("capacity")
                );

                facilities.add(facility);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving facilities: "
                    + e.getMessage());
        }

        return facilities;
    }

    // Update facility
    public boolean updateFacility(Facility facility) {

        String sql = "UPDATE facility SET " +
                     "facility_name = ?, " +
                     "location = ?, " +
                     "capacity = ? " +
                     "WHERE facility_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, facility.getFacilityName());
            statement.setString(2, facility.getLocation());
            statement.setInt(3, facility.getCapacity());
            statement.setInt(4, facility.getFacilityId());

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error updating facility: "
                    + e.getMessage());
            return false;
        }
    }

    // Delete facility
    public boolean deleteFacility(int facilityId) {

        String sql = "DELETE FROM facility WHERE facility_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, facilityId);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error deleting facility: "
                    + e.getMessage());
            return false;
        }
    }
}