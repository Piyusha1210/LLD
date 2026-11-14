package piece;

public abstract class Piece {
    Color color;
    Boolean isAlive;
    Cell cell;

    public Piece(Color color) {
        this.color = color;
        this.isAlive = true;
        this.cell = cell;
    }

    public abstract boolean isValidMove(int row, int col);
}
