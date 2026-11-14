package Entity;

public class Player {
    private int playerId;
    private String name;
    private int position;


    public Player(int playerID, String name, int position) {
        this.playerId = playerID;
        this.name = name;
        this.position = position;
    }

    public int getPostition() {
        return position;
    }

    public void setNewPositions(int newPosition) {
         position = newPosition;
    }

    public String getPlayerName() {
        return name;
    }
}
