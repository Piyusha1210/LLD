package elevator;

import elevator.request.Request;
import elevator.strategy.DirectionStrategy;
import elevator.strategy.ElevatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    List<Elevator> elevatorList;
    ElevatorStrategy elevatorStrategy;

    public ElevatorController() {
        elevatorList = new ArrayList<>(4);
        elevatorStrategy = new DirectionStrategy();
    }

    public void request(Request request) {

    }
}
