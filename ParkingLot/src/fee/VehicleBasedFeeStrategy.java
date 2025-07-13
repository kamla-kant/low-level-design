package fee;

import entities.Vehicle;
import enums.VehicleType;
import parkinglot.ParkingTicket;

import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    private final Map<VehicleType, Double> hourlyRates = Map.of(
            VehicleType.CAR, 20.0,
            VehicleType.BIKE, 10.0,
            VehicleType.TRUCK, 30.0
    );

    @Override
    public double calculateFee(ParkingTicket ticket){
        long duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
        return hourlyRates.get(ticket.getVehicle().getVehicleType())*((double)duration/(60*60));
    }
}
