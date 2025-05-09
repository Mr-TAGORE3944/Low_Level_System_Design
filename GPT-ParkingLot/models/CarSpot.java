package models;

import enums.ParkingSpotType;

public class CarSpot extends ParkingSpot {
    public CarSpot(String Id) {
        this.spotId = Id;
    }

    @Override
    public ParkingSpotType getType() {
        return ParkingSpotType.CAR;
    }
}
