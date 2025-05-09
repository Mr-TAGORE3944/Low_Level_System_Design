import enums.*;
import models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create parking spots
        List<ParkingSpot> carSpots = new ArrayList<>();
        List<ParkingSpot> bikeSpots = new ArrayList<>();
        List<ParkingSpot> truckSpots = new ArrayList<>();

        for (int i = 1; i <= 2; i++)
            carSpots.add(new CarSpot("C" + i));
        for (int i = 1; i <= 2; i++)
            bikeSpots.add(new BikeSpot("B" + i));
        for (int i = 1; i <= 1; i++)
            truckSpots.add(new TruckSpot("T" + i));

        // Map of spot types
        Map<ParkingSpotType, List<ParkingSpot>> floorSpots = new HashMap<>();
        floorSpots.put(ParkingSpotType.CAR, carSpots);
        floorSpots.put(ParkingSpotType.BIKE, bikeSpots);
        floorSpots.put(ParkingSpotType.TRUCK, truckSpots);

        // Create floors and parking lot
        ParkingFloor floor1 = new ParkingFloor("F1", floorSpots);
        List<ParkingFloor> floors = List.of(floor1);

        ParkingLot lot = new ParkingLot("MyLot", floors);

        // Simulate vehicle entries
        Vehicle car = new Car("CAR-123");
        Vehicle bike = new Bike("BIKE-456");

        Ticket carTicket = lot.generateTicket(car);
        System.out.println("Car Ticket: " + (carTicket != null ? carTicket.getTicketId() : "Not issued"));

        Ticket bikeTicket = lot.generateTicket(bike);
        System.out.println("Bike Ticket: " + (bikeTicket != null ? bikeTicket.getTicketId() : "Not issued"));

        // Simulate 10-second delay
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Vehicle exits
        if (carTicket != null)
            lot.exit(carTicket);
        if (bikeTicket != null)
            lot.exit(bikeTicket);
    }
}
