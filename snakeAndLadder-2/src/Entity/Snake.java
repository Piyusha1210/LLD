package Entity;

public class Snake extends Obstacle {

    public Snake(int start, int end) {
        super(start, end);
        if(start < end) {
            throw new IllegalArgumentException("Snake head should be greater than tail");
        }
    }

    public void printMessage() {
        System.out.println("Player bitten by Snake 🐍");
    }
}
