package piece;

import java.awt.*;

public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return false;
    }
}
