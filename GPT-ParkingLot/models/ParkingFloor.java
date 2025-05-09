package models;

import java.util.*;
import enums.*;

public class ParkingFloor {

    public String floorId;
    public Map<ParkingSpotType, List<ParkingSpot>> spotMap;
    public DisplayBoard displayBoard;

    public ParkingFloor(String floorId, Map<ParkingSpotType, List<ParkingSpot>> spotMap) {
        this.floorId = floorId;
        this.spotMap = spotMap;
        Map<ParkingSpotType, Integer> available = new HashMap<>();
        for (ParkingSpotType type : spotMap.keySet()) {
            available.put(type, (int) spotMap.get(type).stream().filter(ParkingSpot::getStatus).count());
        }
        this.displayBoard = new DisplayBoard(available);
    }

    public ParkingSpot getFreeSpot(ParkingSpotType type) {
        for (ParkingSpot spot : spotMap.getOrDefault(type, new ArrayList<>())) {
            if (spot.getStatus())
                return spot;
        }
        return null;
    }

    public void updateDisplay() {
        displayBoard.updateDisplay();
    }

    public void occupySpot(ParkingSpot spot) {
        spot.assignVehicle(spot.vehicle);
        updateDisplay();
    }

    public void freeSpot(ParkingSpot spot) {
        spot.removeVehicle();
        updateDisplay();
    }
}
