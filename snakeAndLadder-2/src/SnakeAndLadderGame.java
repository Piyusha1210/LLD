import Entity.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderGame {
    private List<Dice> dices;
    private Board board;
    private Queue<Player> players;
    private Status status;
    private Player winner;


    private SnakeAndLadderGame(Builder builder) {
        board = new Board(builder.boardSize, builder.obstacles);

        dices = new ArrayList<>();
        for(int i = 0; i < builder.noOfDice; i++) {
            dices.add(new Dice());
        }

        players = new LinkedList<>();
        List<String> playersName = builder.players;
        for(int i = 0; i < playersName.size(); i++) {
            players.add(new Player(i+1, playersName.get(i), 0));
        }

        status = Status.NOT_STARTED;
    }

    public void startGame() {
        status = Status.IN_PROGRESS;
        while(status == Status.IN_PROGRESS) {

            Player player = players.poll();
            makeMove(player);

            if(status == Status.IN_PROGRESS) {
                players.add(player);
            }
        }
    }

    private void makeMove(Player player) {
        int roll = rollDice();
        System.out.printf("%s rolled %d \n", player.getPlayerName(), roll);

        int currentPos = player.getPostition();
        int newPosition = currentPos + roll;

        if(newPosition > board.getSize()) {
            System.out.println("Oops you have make move out of the board");
            return;
        }
        if(newPosition == board.getSize()) {
            winner = player;
            status = Status.COMPLETED;
            System.out.printf("Hurray %s wins the game\n", player.getPlayerName());
            return;
        }

        newPosition = board.getFinalPosition(newPosition);
        player.setNewPositions(newPosition);
        System.out.printf("%s reached %d\n", player.getPlayerName(), newPosition);
    }

    private int rollDice() {
        int moveCount = 0;
        for(Dice dice : dices) {
            moveCount += dice.rollDice();
        }
        return moveCount;
    }

    public static class Builder {
        Integer boardSize = 100;
        List<String> players;
        Integer noOfDice = 1;
        Integer diceFaces = 6;
        List<Obstacle> obstacles;

        public Builder(List<String> players) {
            this.players = players;
        }

        public Builder setBoardSize(int size) {
            this.boardSize = size;
            return this;
        }

        public Builder setNoOfDice(int noOfDice) {
            this.noOfDice = noOfDice;
            return this;
        }

        public Builder setObstacles(List<Obstacle> obstacles) {
            this.obstacles = obstacles;
            return this;
        }

        public Builder setDiceFaces(int diceFaces) {
            this.diceFaces = diceFaces;
            return this;
        }

        public SnakeAndLadderGame build() {
            return new SnakeAndLadderGame(this);
        }
    }
}
