package fee;

import entities.Vehicle;
import parkinglot.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy{
    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(ParkingTicket ticket) {
        long duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
        return RATE_PER_HOUR*((double) duration /(60*60));
    }
}
