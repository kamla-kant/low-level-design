import java.util.*;

public class ElevatorController {
    private final List<Elevator> elevators;

    ElevatorController(int numElevators, int _capacity) {
        elevators = new ArrayList<>();
        for(int i=0;i<numElevators;i++) {
            Elevator elevator = new Elevator(i+1, _capacity);
            elevators.add(elevator);
            new Thread(()-> {
                elevator.processRequests();
            }).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = findOptimalElevator(sourceFloor, destinationFloor);
        optimalElevator.addRequest(new Request(sourceFloor, destinationFloor));
    }

    private synchronized  Elevator findOptimalElevator(int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
            if (distance < minDistance) {
                minDistance = distance;
                optimalElevator = elevator;
            }
        }
        System.out.println("Optimal elevator for "+ sourceFloor +" to "+destinationFloor +" is "+optimalElevator.getId());
        return optimalElevator;
    }
}
