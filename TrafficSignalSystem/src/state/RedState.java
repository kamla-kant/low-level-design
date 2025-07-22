package state;

import direction.Direction;
import trafficlight.TrafficLight;
import trafficlight.TrafficSignalController;

public class RedState implements SignalState{
    @Override
    public void handle(TrafficLight light, TrafficSignalController controller, Direction direction) {
        System.out.println("Direction: "+direction +" | State: RED");
            int duration = controller.getSignalDuration(direction, this);
            controller.scheduleStateChange(light, direction, new GreenState(), duration);
    }

    @Override
    public String getName() {
        return "RED";
    }
}
