import java.util.*;

public class Show {
    private String movieName;
    private Long startTime;
    private Long endTime;
    private Long duration;
    private Map<String, List<Seat>> seats;

    public Show(String movieName, Long startTime, Long endTime, Long duration, Integer premiumSeatRow, Integer premiumSeatCol,
                Integer normalSeatRow, Integer normalSeatCol, Integer premiumSeatPrice, Integer normalSeatPrice) {
        this.movieName = movieName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        seats = new HashMap<>();
        addSeats(premiumSeatRow, premiumSeatCol, normalSeatRow, normalSeatCol, premiumSeatPrice, normalSeatPrice);
    }

    public Long getStartTime() {
        return startTime;
    }

    private void addSeats(Integer premiumSeatRow, Integer premiumSeatCol, Integer normalSeatRow,
                           Integer normalSeatCol, Integer premiumSeatPrice, Integer normalSeatPrice) {

        String seatRow = "A";
        for (int i = 0; i < premiumSeatRow; i++) {
            seats.put(seatRow, new ArrayList<>());
            for (int  j = 1; j <= premiumSeatCol; j++) {
                seats.get(seatRow).add(new Seat(SeatType.PREMIUM, seatRow+j, premiumSeatPrice));
            }
            seatRow = String.valueOf((char)(seatRow.charAt(0) + 1));
        }

        for (int i = 1; i <= normalSeatRow; i++) {
            seats.put(seatRow, new ArrayList<>());
            for (int j = 1; j <= normalSeatCol; j++) {
                seats.get(seatRow).add(new Seat(SeatType.NORMAL, seatRow + j, normalSeatPrice));
            }
            seatRow = String.valueOf((char)(seatRow.charAt(0) + 1));
        }
    }

    public void showAvailableSeats() {
        for(Map.Entry<String, List<Seat>> entry: seats.entrySet()) {
            for(Seat seat: entry.getValue()) {
                if(seat.isAvailable()) {
                    System.out.print(seat.getSeatNumber());
                }
                else {
                    System.out.print("X");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Seat getSeat(String seatNumber) {
        String rowNum = seatNumber.charAt(0) + "";
        Integer colNum = Integer.valueOf(seatNumber.substring(1));

        Seat seat = seats.get(rowNum).get(colNum-1);
        if(!seat.isAvailable()) {
            System.out.println("Sorry seat is not available");
            return null;
        }
        return seat;
    }
}
