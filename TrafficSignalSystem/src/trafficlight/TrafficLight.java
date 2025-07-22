package trafficlight;

import direction.Direction;
import state.RedState;
import state.SignalState;

public class TrafficLight {
    private SignalState state;
    private Direction direction;

    public TrafficLight(Direction direction) {
        this.state = new RedState();
        this.direction = direction;
    }

    public SignalState getState() {
        return state;
    }

    public void setState(SignalState state) {
        this.state = state;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void handle(TrafficSignalController controller){
        state.handle(this, controller, direction);
    }
}
