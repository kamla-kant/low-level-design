package entities;

import enums.VehicleType;
import parkinglot.ParkingSpot;

public class BikeSpot extends ParkingSpot {
    public BikeSpot(int spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        if(vehicle.getVehicleType().equals(VehicleType.BIKE)) return true;
        return false;
    }
}
