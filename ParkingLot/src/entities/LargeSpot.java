package entities;

import enums.VehicleType;
import parkinglot.ParkingSpot;

public class LargeSpot extends ParkingSpot {
    public LargeSpot(int spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)) return true;
        return false;
    }
}
