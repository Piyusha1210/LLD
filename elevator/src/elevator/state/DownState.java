package elevator.state;

import elevator.Elevator;

public class DownState implements ElevatorState{

    public void move(Elevator elevator) {
        elevator.setCurrentFloor(elevator.getCurrentFloor()-1);
    }
}
