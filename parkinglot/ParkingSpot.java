import java.util.*;
import vehicletype.*;

@SuppressWarnings("unused")
public class ParkingSpot {
    private final int spotnumber;
    private final VehicleType type;
    private Vehicle parkedvehicle;

    public ParkingSpot(int spotnumber, VehicleType type) {
        this.type = type;
        this.spotnumber = spotnumber;
        // this.parkedvehicle = null;
    }

    public synchronized boolean isAvailable() {
        return parkedvehicle == null;
    };

    public synchronized void parkVehicle(Vehicle vehicle) throws IllegalAccessException {
        if (isAvailable() && vehicle.getType() == type) {
            parkedvehicle = vehicle;
        } else {
            throw new IllegalAccessException("Invalid Vehicle type or Spot Already Filled!");
        }
    }

    public synchronized void unparkVehicle() {
        parkedvehicle = null;
    };

    // getters

    public Vehicle getParkedVehicle() {
        return parkedvehicle;
    };

    public VehicleType getVehicleType() {
        return type;
    };

    public int getSpotNumber() {
        return spotnumber;
    }
}
