public class SnakeNode {
    private int row;
    private int col;
    private SnakeNode prev;
    private SnakeNode next;

    public SnakeNode(int row, int col) {
        this.row = row;
        this.col = col;
        prev =  null;
        next = null;
    }

    public SnakeNode getNext() {
        return next;
    }

    public void setNext(SnakeNode next) {
        this.next = next;
    }
    public SnakeNode getPrev() {
        return prev;
    }
    public void setPrev(SnakeNode prev) {
        this.prev = prev;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
}
