package entity;

public enum Coin {
    One(1),
    Two(5),
    FiveTwo(5),
    Ten(10),
    Twenty(20),
    Fifty(50),
    Hundred(100);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
