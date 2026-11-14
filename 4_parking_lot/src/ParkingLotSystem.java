import java.util.*;

public class ParkingLotSystem {
    Map<String, Ticket> activeTickets;
    ParkingStrategy strategy;
    List<Spot> spots;
    Set<String> parkedVehicle;

    ParkingLotSystem(ParkingStrategy strategy) {
        this.strategy = strategy;
        this.activeTickets = new HashMap<>();
        this.spots = new ArrayList<>();
        this.parkedVehicle = new HashSet<>();

        spots.add(new Spot(VehicleType.BIKE, 1L));
        spots.add(new Spot(VehicleType.BIKE, 2L));

        spots.add(new Spot(VehicleType.CAR, 3L));
        spots.add(new Spot(VehicleType.CAR, 4L));
        spots.add(new Spot(VehicleType.CAR, 5L));

        spots.add(new Spot(VehicleType.TRUCK, 6L));
    }

    synchronized Ticket parkVehicle(Vehicle vehicle) {
        try {
            if(vehicle.regNumber == null) {
                System.out.println("Invalid reg number");
                return null;
            }
            if(parkedVehicle.contains(vehicle.getRegNumber())) {
                System.out.println(vehicle.getRegNumber() + " already parked");
                return null;
            }
            Spot spot = strategy.getParkingSpot(vehicle.getVehicleType(), spots);
            spot.occupySpot();
            Ticket ticket = new Ticket(vehicle, spot);
            activeTickets.put(ticket.getTicketID(), ticket);
            parkedVehicle.add((vehicle.getRegNumber()));
            System.out.println(vehicle.getVehicleType() + " parked at spot: " + spot.getSpotID());
            return ticket;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    synchronized void unParkVehicle(Ticket ticket) {
        try {
            if(ticket == null
                    || !activeTickets.containsKey(ticket.getTicketID())
                    || !validateTicket(ticket, activeTickets.get(ticket.ticketID))
                    || !parkedVehicle.contains(ticket.getVehicle().getRegNumber())) {
                System.out.println("Invalid Ticket");
                return;
            }
            Spot spot = ticket.getSpot();
            spot.vacateSpot();
            ticket.checkoutVehicle();
            activeTickets.remove(ticket.getTicketID());
            parkedVehicle.remove(ticket.getVehicle().getRegNumber());
            System.out.println(spot.getType() + " Unparked from spot: " + spot.getSpotID());
            // Calculate Fee on basis of checkin & checkout time

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void addSpot(Spot spot) {
        spots.add(spot);
    }

    boolean validateTicket(Ticket userTicket, Ticket systemTicket) {
        if(userTicket == systemTicket)
            return true;
        return false;
    }
}
