package Entity;

public class Ladder extends Obstacle {

    public Ladder(int start, int end) {
        super(start, end);
        if(start > end) {
            throw new IllegalArgumentException("Ladder bootom should be greater than top");
        }
    }

    public void printMessage() {
        System.out.println("Hurray player got a ladder 🪜");
    }
}
