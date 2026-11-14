package elevator.strategy;

import elevator.Elevator;
import elevator.request.Direction;
import elevator.request.Request;

import java.util.List;

import static elevator.request.Direction.*;

public class DirectionStrategy implements ElevatorStrategy{

    @Override
    public Elevator assignElevator(List<Elevator> elevators, Request request) {
        Elevator idleMatch = null;
        int bestScore = -1;
        for(Elevator elevator: elevators) {
            int score = 0;
            if(elevator.getDirection() ==  getDirection(elevator, request)) {
                score += Math.abs(10- (elevator.getCurrentFloor() - request.getFloor()));
            }

            if(score > bestScore)
                idleMatch = elevator;
        };
        return idleMatch;
    }

    private Direction getDirection(Elevator e, Request r) {
        if(e.getCurrentFloor() < r.getFloor())
            return UP;
        else if(e.getCurrentFloor() > r.getFloor())
            return DOWN;
        return IDLE;
    }
 }

/*
* 1. Direction should match
*       1.1 Minimum gap
* 2. Direction doesn't match
* */