package enitty;

public class Dice {
    private int value;

    public Dice() {
        this.value = 1;
    }

    public int roll() {
        this.value = (int)(Math.random() * 6) + 1;
        return this.value;
    }
}
