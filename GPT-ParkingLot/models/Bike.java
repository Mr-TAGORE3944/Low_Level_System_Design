package models;

import enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String plate) {
        super(plate);
        this.type = VehicleType.BIKE;
    }
}
