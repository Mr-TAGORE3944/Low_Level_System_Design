package models;

import enums.ParkingSpotType;

public class TruckSpot extends ParkingSpot {
    public TruckSpot(String Id) {
        this.spotId = Id;
    }

    @Override
    public ParkingSpotType getType() {
        return ParkingSpotType.TRUCK;
    }
}
