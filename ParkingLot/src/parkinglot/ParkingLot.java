package parkinglot;

import entities.Vehicle;
import fee.FeeStrategy;
import fee.FlatRateFeeStrategy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParkingLot {
    private static ParkingLot instance = new ParkingLot();
    private List<ParkingFloor> floors = new CopyOnWriteArrayList<>();
    private Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;

    private ParkingLot() {
        feeStrategy = new FlatRateFeeStrategy();
    }

    public static synchronized ParkingLot getInstance(){
        return instance;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) throws Exception {
        for(ParkingFloor floor: floors) {
            Optional<ParkingSpot> parkingSpot = floor.getAvailableSpot(vehicle);
            if(parkingSpot.isPresent()) {
                ParkingSpot spot= parkingSpot.get();
                if(spot.assignVehicle(vehicle)) {
                    ParkingTicket ticket = new ParkingTicket(vehicle, spot);
                    activeTickets.put(vehicle.getLicenseNumber(), ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No available spot for : " + vehicle.getVehicleType());
    }

    public synchronized double unparkVehicle(String licence) throws Exception {
        ParkingTicket ticket = activeTickets.get(licence);
        if(ticket == null) throw new Exception("Ticket not found!");
        activeTickets.remove(licence);
        ticket.getSpot().removeVehicle();
        ticket.setEntryTimestamp();
        return feeStrategy.calculateFee(ticket);
    }
}
