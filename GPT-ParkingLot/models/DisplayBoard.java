package models;

import java.util.*;

import enums.ParkingSpotType;

public class DisplayBoard {
    public Map<ParkingSpotType, Integer> availableSpots;

    public DisplayBoard(Map<ParkingSpotType, Integer> availableSpots) {
        this.availableSpots = availableSpots;
    }

    public void updateDisplay() {
        for (Map.Entry<ParkingSpotType, Integer> entry : availableSpots.entrySet()) {
            System.out.println(entry.getKey() + " Spots: " + entry.getValue());
        }
    }

    public void setAvailable(ParkingSpotType type, int count) {
        availableSpots.put(type, count);
    }
}
