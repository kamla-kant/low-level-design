package parkinglot;

import entities.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    public Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle) {
        return spots.stream().filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle)).findFirst();
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
