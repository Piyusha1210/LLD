public class Fruit {
    private int row;
    private int col;

    private Fruit(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Fruit generateFruit() {
        int r = (int) ((Math.random() * 20) + 1);
        int c = (int) ((Math.random() * 20) + 1);
        return new Fruit(r, c);
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
