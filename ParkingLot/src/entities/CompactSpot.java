package entities;

import enums.VehicleType;
import parkinglot.ParkingSpot;

public class CompactSpot extends ParkingSpot {
    public CompactSpot(int spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        if(vehicle.getVehicleType().equals(VehicleType.CAR)) return true;
        return false;
    }
}
