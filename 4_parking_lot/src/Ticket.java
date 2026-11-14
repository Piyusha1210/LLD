import lombok.Getter;

import java.util.UUID;

@Getter
public class Ticket {
    String ticketID;
    Vehicle vehicle;
    Spot spot;
    Long checkInTime;
    Long checkoutTime;

    public Ticket(Vehicle vehicle, Spot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.ticketID = UUID.randomUUID().toString();
        this.checkInTime = System.currentTimeMillis();
    }

    public void checkoutVehicle() {
        this.checkoutTime = System.currentTimeMillis();
    }
}
