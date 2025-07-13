package fee;

import entities.Vehicle;
import parkinglot.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
