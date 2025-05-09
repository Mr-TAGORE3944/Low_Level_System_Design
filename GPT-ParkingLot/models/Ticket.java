
package models;

import java.util.Date;

public class Ticket {
    public String tickedId;
    public Vehicle vehicle;
    public ParkingSpot spot;
    public Date entryTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.tickedId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = new Date();
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public String getTicketId() {
        return tickedId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getEntryDate() {
        return entryTime;
    }
}
