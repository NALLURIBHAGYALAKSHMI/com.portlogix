package com.portlogix;

import com.portlogix.model.Ship;
import com.portlogix.repository.ShipRepository;

public class TestShipData {

    public static void main(String[] args) {

        ShipRepository repository = new ShipRepository();

        for (Ship ship : repository.getAllShips()) {
            System.out.println(ship);
        }
    }
}