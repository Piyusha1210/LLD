package elevator.state;

import elevator.Elevator;

public class UpState implements ElevatorState{
    public void move(Elevator elevator) {
        elevator.setCurrentFloor(elevator.getCurrentFloor()+1);
    }
}
