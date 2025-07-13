package parkinglot;

import entities.Vehicle;

public abstract class ParkingSpot {
    private int spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotId) {
        this.spotId = spotId;
        this.isOccupied = false;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle){
        if(isOccupied) return false;
        this.vehicle = vehicle;
        this.isOccupied = true;
        return true;
    }

    public synchronized void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);

    public int getSpotId() {
        return spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
