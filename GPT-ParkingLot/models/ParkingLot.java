package models;

import java.util.*;

import enums.*;
import models.*;
import services.PaymentService;

public class ParkingLot {
    public String name;
    public List<ParkingFloor> floors;
    public int ticketCounter = 1;

    public ParkingLot(String name, List<ParkingFloor> floors) {
        this.name = name;
        this.floors = floors;
    }

    public Ticket generateTicket(Vehicle vehicle) {

        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.getFreeSpot(ParkingSpotType.valueOf(vehicle.getType().name()));
            if (spot != null) {
                spot.assignVehicle(vehicle);
                return new Ticket("TICKET" + ticketCounter++, vehicle, spot);
            }
        }
        System.out.println("No Space Available");

        return null;
    }

    public void exit(Ticket ticket) {
        PaymentService paymentService = new PaymentService();
        paymentService.pay(ticket);
        ticket.getSpot().removeVehicle();
    }
}
