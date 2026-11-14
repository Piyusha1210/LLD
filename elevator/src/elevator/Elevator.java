package elevator;

import com.sun.source.tree.NewArrayTree;
import elevator.request.Direction;
import elevator.request.Request;
import elevator.state.DownState;
import elevator.state.ElevatorState;
import elevator.state.IdleState;
import elevator.state.UpState;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static elevator.request.Direction.*;

@Getter
@Setter
public class Elevator {
    int elevatorID;
    int currentFloor;
    PriorityQueue<Integer> upRequests;
    PriorityQueue<Integer> downRequests;
    Direction direction;
    ElevatorState elevatorState;

    Elevator() {
        downRequests = new NewArrayTree<>();
        upRequests = new NewArrayTree<>();
        elevatorState = new IdleState();
    }


    public void move() {
        while(true) {
            if(direction == UP) {
                if(!upRequests.isEmpty()) {
                    elevatorState = new UpState();
                }
                else if(!downRequests.isEmpty()) {
                    elevatorState = new DownState();
                }
                else {
                    elevatorState = new IdleState();
                }
            }
            else{
                if(!downRequests.isEmpty()) {
                    elevatorState = new DownState();
                }
                else if(!upRequests.isEmpty()) {
                    elevatorState = new UpState();
                }
                else {
                    elevatorState = new IdleState();
                }
            }

            elevatorState.move(this);

        }
    }

}
