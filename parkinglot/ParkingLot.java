import java.util.*;
import vehicletype.*;

@SuppressWarnings("unused")
public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    public ParkingLot() {
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public boolean parkvehicle(Vehicle vehicle) throws IllegalAccessException {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Vehicle Parked!");
                return true;
            }
        }

        System.out.println("Cloun't Parked Vehicle");
        return false;
    }

    public boolean unparkvehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkvehicle(vehicle)) {
                System.out.println("Vehicle Unparked!");
                return true;
            }
        }
        System.out.println("Vehicle Not thier!");
        return false;
    }

    public void displayAvaliablity() {
        for (Level level : levels) {
            level.displayAvaliablity();
        }
    }

}
