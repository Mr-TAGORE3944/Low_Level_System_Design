package models;

import enums.ParkingSpotType;

public class BikeSpot extends ParkingSpot {
    public BikeSpot(String Id) {
        this.spotId = Id;
    }

    @Override
    public ParkingSpotType getType() {
        return ParkingSpotType.BIKE;
    }
}
