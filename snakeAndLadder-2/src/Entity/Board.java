package Entity;

import java.util.ArrayList;
import java.util.List;

public class Board {
    Integer boardSize;
    List<Cell> cells;

    public Board(int size, List<Obstacle> obstacles) {
        boardSize = size;
        cells = new ArrayList<>();

        cells.add(new Cell(0));
        for(int i = 1; i <=  boardSize; i++) {
            cells.add(new Cell(i));
        }

        for(Obstacle obstacle: obstacles) {
            Cell cell = cells.get(obstacle.getStart());
            cell.addObstacle(obstacle);
        }
    }

    public Integer getSize(){
        return boardSize;
    }

    public int getFinalPosition(Integer position) {
        Cell cell = cells.get(position);
        if(cell.getHasObstacle()) {
            Obstacle obstacle = cell.getObstacle();
            obstacle.printMessage();
            return obstacle.getEnd();
        }
        return position;
    }
}
