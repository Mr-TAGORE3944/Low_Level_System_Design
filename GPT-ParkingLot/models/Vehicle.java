package models;

import enums.VehicleType;

public class Vehicle {
    public String licensePlate;
    public VehicleType type;

    public Vehicle(String plate) {
        this.licensePlate = plate;
    }

    // gettters
    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

}
