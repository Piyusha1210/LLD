public class Seat {
    private SeatType seatType;
    private String seatNumber;
    private Integer price;
    private Boolean isAvaialble;

    Seat(SeatType seatType, String seatNumber, Integer price) {
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isAvaialble = true;
    }

    public Boolean isAvailable() {
        return isAvaialble;
    }

    public void book() {
        isAvaialble = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}
