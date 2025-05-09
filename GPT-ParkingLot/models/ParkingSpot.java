package models;

import enums.ParkingSpotType;

public abstract class ParkingSpot {
    public String spotId;
    public boolean isFree = true;
    public Vehicle vehicle;

    public abstract ParkingSpotType getType();

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
    }

    public boolean getStatus() {
        return isFree;
    }

    public String getSpotId() {
        return spotId;
    }
}
