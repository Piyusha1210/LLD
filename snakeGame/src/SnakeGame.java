public class SnakeGame {
    Fruit fruit;
    Snake snake;

    SnakeGame () {
        this.fruit = Fruit.generateFruit();
        this.snake = new Snake();
    }

    void changeDirection(Direction direction) {
        snake.changeDirection(direction);
    }

    private void moveSnake() {
        snake.moveSnake();
        SnakeNode head = snake.getHead();
        if(head.getRow() == fruit.getRow() && head.getCol() == fruit.getCol()) {
            snake.addNewNode();
            fruit = Fruit.generateFruit();
        }
    }
}


/*

Requirements
- A snake with initilial size 1,
- A fruit random placed anywhere in the grid(20*20)
- if snake eats fruit then snake length will increase by one & a new fruit will randomly placed at some cell
- If snake touches any of the boundary or touch itself then will die and game end

Entities
- SnakeGame
- Snake
- SnakeNode
- Fruit
* */
