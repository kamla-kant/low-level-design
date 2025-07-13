package parkinglot;

import entities.Vehicle;

import java.time.LocalTime;
import java.util.UUID;

public class ParkingTicket {
    private String ticketId;
    private long entryTimestamp;
    private long exitTimestamp;
    private Vehicle vehicle;
    private ParkingSpot spot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID().toString();
        this.entryTimestamp = System.currentTimeMillis()/1000;
        this.vehicle = vehicle;
        this.spot = spot;
    }

    public void setEntryTimestamp(){
        exitTimestamp = System.currentTimeMillis()/1000;
    }

    public String getTicketId() {
        return ticketId;
    }

    public long getEntryTimestamp() {
        return entryTimestamp;
    }

    public long getExitTimestamp() {
        return exitTimestamp;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }
}
