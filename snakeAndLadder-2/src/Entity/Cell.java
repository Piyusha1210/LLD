package Entity;

public class Cell {
    private int cellId;
    private Boolean hasObstacle;
    private Obstacle obstacle;

    Cell(int id) {
        this.cellId = id;
        hasObstacle = false;
    }

    public int getCellID() {
        return cellId;
    }

    public Boolean getHasObstacle() {
        return hasObstacle;
    }

    public void addObstacle(Obstacle obstacle) {
        if(getHasObstacle()) {
            throw new IllegalArgumentException("Cell {cellID} already has an obstacle");
        }
        this.obstacle = obstacle;
        this.hasObstacle = true;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
}
