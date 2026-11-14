import enitty.Board;
import enitty.Dice;
import enitty.Player;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {

    private Board board;
    private Dice dice;
    private List<Player> players = new ArrayList<>();
    private final Integer noOfPlayers;

    private static SnakeAndLadderGame instance;

    private SnakeAndLadderGame(int numberOfPlayers) {
        this.board = new Board();
        this.dice = new Dice();

        for(int i = 0; i < numberOfPlayers; i++) {
            this.players.add(new Player(i+1));
        }

        noOfPlayers = numberOfPlayers;
    }

    public static SnakeAndLadderGame getInstance(int numberOfPlayers) {
        if(instance == null) {
            instance = new SnakeAndLadderGame(numberOfPlayers);
        }
        return instance;
    }

    public void startGame() {
        Boolean flag = true;
        while(flag) {
            for(Player player: players) {

                int move = dice.roll();
                int newPosition = player.getPosition() + move;
                if(newPosition > 100) {
                    System.out.println("Invalid move! You can't go beyond 100 position");
                    continue;
                }
                if(player.getPosition() == 100) {
                    System.out.println("Congratulations! player-" + player.getUserID() + " Wins the game!");
                    flag = false;
                    break;
                }

                newPosition = board.getNewPosition(newPosition);
                player.setNewPosition(newPosition);
            }
        }
    }
}
