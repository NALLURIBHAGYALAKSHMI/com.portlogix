package com.portlogix.service;

import com.portlogix.model.Container;
import com.portlogix.repository.ContainerRepository;

import java.util.List;

public class ContainerService {

    private final ContainerRepository repository;

    public ContainerService() {
        repository = new ContainerRepository();
    }

    // Add container
    public boolean addContainer(Container container) {

        if (container == null) {
            System.out.println("Container cannot be null.");
            return false;
        }

        if (container.getContainerCode() == null ||
            container.getContainerCode().trim().isEmpty()) {

            System.out.println("Container code is required.");
            return false;
        }

        if (container.getWeight() <= 0) {

            System.out.println("Container weight must be greater than 0.");
            return false;
        }

        return repository.addContainer(container);
    }

    // Find container
    public Container findContainer(int containerId) {

        return repository.findById(containerId);
    }

    // Get all containers
    public List<Container> getAllContainers() {

        return repository.getAllContainers();
    }

    // Update container
    public boolean updateContainer(Container container) {

        if (container == null) {
            System.out.println("Container cannot be null.");
            return false;
        }

        return repository.updateContainer(container);
    }

    // Delete container
    public boolean deleteContainer(int containerId) {

        return repository.deleteContainer(containerId);
    }

    // Display all containers
    public void displayContainers() {

        List<Container> containers =
                repository.getAllContainers();

        if (containers.isEmpty()) {

            System.out.println("No containers found.");
            return;
        }

        System.out.println("\n========== CONTAINER LIST ==========");

        for (Container container : containers) {

            System.out.println(container);
        }

        System.out.println("====================================");
    }
}