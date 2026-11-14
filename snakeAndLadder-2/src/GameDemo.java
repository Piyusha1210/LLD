import Entity.Ladder;
import Entity.Obstacle;
import Entity.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int boardSize = sc.nextInt();
//        int noOfDice = sc.nextInt();
//        int diceFaces = sc.nextInt();

        int boardSize = 50;
        int noOfDice = 1;
        int diceFaces = 6;

        int noOfPlayers = sc.nextInt();
        List<String> players = new ArrayList<>();
        for(int i = 0; i < noOfPlayers; i++) {
            String s = sc.next();
            players.add(s);
        }

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Snake(34, 17));
        obstacles.add(new Snake(26, 8));
        obstacles.add(new Snake(47, 26));
        obstacles.add(new Snake(43, 36));

        obstacles.add(new Ladder(6, 14));
        obstacles.add(new Ladder(11, 33));
        obstacles.add(new Ladder(29, 42));
        obstacles.add(new Ladder(33, 46));

        SnakeAndLadderGame game = new SnakeAndLadderGame
                .Builder(players)
                .setNoOfDice(noOfDice)
                .setDiceFaces(diceFaces)
                .setBoardSize(boardSize)
                .setObstacles(obstacles)
                .build();

        game.startGame();
    }
}