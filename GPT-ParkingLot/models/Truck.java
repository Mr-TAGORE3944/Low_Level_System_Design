package models;

import enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String plate) {
        super(plate);
        this.type = VehicleType.TRUCK;
    }
}
