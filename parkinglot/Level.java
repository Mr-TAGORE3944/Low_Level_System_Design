import java.util.*;
import vehicletype.*;

@SuppressWarnings("unused")
public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpot;

    public Level(int floor, int numspot) {
        this.floor = floor;
        parkingSpot = new ArrayList<ParkingSpot>(numspot);

        double spotsforbikes = 0.50;
        double spotsforcars = 0.40;
        double spotsfortrucks = 0.10;

        int numbikes = (int) (numspot * spotsforbikes);
        int numcars = (int) (numspot * spotsforcars);
        int numtrucks = (int) (numspot * spotsfortrucks);

        for (int i = 1; i <= numbikes; i++) {
            parkingSpot.add(new ParkingSpot(i, VehicleType.Car));
        }

        for (int i = numbikes; i <= numbikes + numcars; i++) {
            parkingSpot.add(new ParkingSpot(i, VehicleType.MotorBikt));
        }

        for (int i = numbikes + numcars; i <= numspot; i++) {
            parkingSpot.add(new ParkingSpot(i, VehicleType.Truck));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) throws IllegalAccessException {
        for (ParkingSpot spot : parkingSpot) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkvehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpot) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvaliablity() {
        System.out.println("Level : " + floor + " Avaliablity");
        for (ParkingSpot spot : parkingSpot) {
            System.out.println("Spot: " + spot.getSpotNumber() + ":"
                    + (spot.isAvailable() ? "Occupied By " : "Available For") + " " + spot.getParkedVehicle());
        }
    }

}
