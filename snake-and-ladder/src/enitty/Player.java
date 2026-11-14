package enitty;

public class Player {
    Integer userID;
    Integer position;

    public Player(Integer userID) {
        this.userID = userID;
        this.position = 0;
    }

    public void setNewPosition(Integer newPosition) {
        this.position = newPosition;
    }

    public int getUserID() {
        return userID;
    }

    public int getPosition() {
        return position;
    }
}
