import java.util.*;
import vehicletype.*;

public class ParkingLotDemo {
    public static void run() throws IllegalAccessException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 80));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorbike = new MotorBike("M1234");

        // Park vehicles
        parkingLot.parkvehicle(car);
        parkingLot.parkvehicle(truck);
        parkingLot.parkvehicle(motorbike);

        // Display availability
        parkingLot.displayAvaliablity();

        // Unpark vehicle
        parkingLot.unparkvehicle(motorbike);

        // Display updated availability
        parkingLot.displayAvaliablity();
    }

    public static void main(String[] args) throws IllegalAccessException {
        run();
    }
}