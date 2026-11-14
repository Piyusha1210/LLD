public class Snake {
    private SnakeNode head;
    private SnakeNode tail;
    private Direction direction;

    public Snake() {
        head = new SnakeNode(10, 10);
        tail = new SnakeNode(11, 10);
        direction = Direction.UP;
    }

    public void changeDirection(Direction direction) {
        this.direction = direction;
    }

    boolean moveSnake() {
        removeLastNode();
        return addNewNode();
    }

    public SnakeNode getHead() {
        return head;
    }

    public Boolean addNewNode() {
        int row = head.getRow();
        int col = head.getCol();

        if(direction == Direction.UP) {
            row--;
        }
        else if(direction == Direction.DOWN) {
            row++;
        }
        if(direction == Direction.LEFT) {
            col--;
        }
        else if(direction == Direction.RIGHT) {
            col++;
        }

        if(!checkState(row, col)) {
            return false;
        }

        SnakeNode newHead = new SnakeNode(row, col);
        newHead.setNext(head);
        head.setPrev(newHead);
        head = newHead;
        return true;
    }

    private void removeLastNode() {
        tail = tail.getPrev();
    }

    private boolean checkState(int row, int col) {
        if(row < 0 || col < 0 || row >= 20 || col >= 20) {
            return false;
        }

        SnakeNode node = head;
        while(node != null) {
            if(node.getCol() == col && node.getRow() == row) {
                return false;
            }
            node = node.getNext();
        }


        return true;
    }
}
