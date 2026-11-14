import piece.Piece;

public class Cell {
    private int row;
    private int col;
    private Color color;
    private Boolean isEmpty;
    private Piece piece;


    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        int idx = row * 8 + col;
        if(idx % 2 == 0)
            color = Color.BLACK;
        else
            color = Color.WHITE;

        isEmpty = true;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
