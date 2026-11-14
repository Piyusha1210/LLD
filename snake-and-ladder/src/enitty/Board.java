package enitty;

import enitty.snakeladder.Ladder;
import enitty.snakeladder.Snake;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Snake> snakes = new ArrayList<>();
    List<Ladder> ladders = new ArrayList<>();

    public Board() {
        snakes.add(new Snake(14, 7));
        snakes.add(new Snake(34, 17));
        snakes.add(new Snake(64, 23));
        snakes.add(new Snake(86, 75));
        snakes.add(new Snake(97, 37));

        ladders.add(new Ladder(28, 73));
        ladders.add(new Ladder(8, 26));
        ladders.add(new Ladder(43, 63));
        ladders.add(new Ladder(52, 89));
    }

    public Integer getNewPosition(int newPosition) {
        for (Snake snake: snakes) {
            if(snake.getStart() == newPosition) {
                System.out.println("Oh no! You got bitten by a snake! Back to position " + snake.getEnd());
                return snake.getEnd();
            }
        }
        for (Ladder ladder: ladders) {
            if(ladder.getStart() == newPosition) {
                System.out.println("Oh wow! You got ladder! Moved to position " + ladder.getEnd());
                return ladder.getEnd();
            }
        }
        return newPosition;
    }

}
