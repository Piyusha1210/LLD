package Entity;

public abstract class Obstacle {
    private int start;
    private int end;

    Obstacle(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public abstract void printMessage();
}
