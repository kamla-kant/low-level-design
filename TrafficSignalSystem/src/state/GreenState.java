package state;

import direction.Direction;
import trafficlight.TrafficLight;
import trafficlight.TrafficSignalController;

public class GreenState implements SignalState{
    @Override
    public void handle(TrafficLight light, TrafficSignalController controller, Direction direction) {
        System.out.println("Direction: "+direction +" | State: GREEN");
            int duration = controller.getSignalDuration(direction, this);
            controller.scheduleStateChange(light, direction, new YellowState(), duration);
    }

    @Override
    public String getName() {
        return "GREEN";
    }
}
