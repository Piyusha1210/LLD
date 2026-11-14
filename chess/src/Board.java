import piece.King;
import piece.Piece;

public class Board {
    private Cell[][] board;

    private Board() {
        board = new Cell[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new Cell(i, j);
            }
        }
    }

    private void startGame() {
        Piece king = new King(Color.BLACK);

    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public Piece getPiece(int row, int col) {
        return board[row][col].getPiece();
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col].setPiece(piece);
    }
}
