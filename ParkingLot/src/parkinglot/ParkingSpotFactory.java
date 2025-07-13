package parkinglot;

import entities.BikeSpot;
import entities.CompactSpot;
import entities.LargeSpot;
import entities.Vehicle;
import enums.ParkingSpotType;

public class ParkingSpotFactory {
    public static ParkingSpot createParkingSpots(ParkingSpotType spotType, int spotId) {
        return switch (spotType) {
            case ParkingSpotType.BIKE -> new BikeSpot(spotId);
            case ParkingSpotType.COMPACT -> new CompactSpot(spotId);
            case ParkingSpotType.LARGE -> new LargeSpot(spotId);
            default -> throw new IllegalArgumentException("Unknown parking spot type: " + spotType);
        };
    }
}
