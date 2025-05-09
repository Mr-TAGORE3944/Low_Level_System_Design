package models;

import enums.VehicleType;

public class Car extends Vehicle {
    public Car(String plate) {
        super(plate);
        this.type = VehicleType.CAR;
    }
}
