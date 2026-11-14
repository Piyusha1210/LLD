package elevator.strategy;

import elevator.Elevator;
import elevator.request.Request;

import java.util.List;

public interface ElevatorStrategy {
    void assignElevator(List<Elevator> elevators, Request request);
}
