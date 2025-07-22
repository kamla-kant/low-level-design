package state;

import direction.Direction;
import trafficlight.TrafficLight;
import trafficlight.TrafficSignalController;

public interface SignalState {
    void handle(TrafficLight trafficLight, TrafficSignalController trafficSignalController, Direction direction);
    String getName();

}
