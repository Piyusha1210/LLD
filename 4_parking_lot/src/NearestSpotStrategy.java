import java.util.List;

public class NearestSpotStrategy implements ParkingStrategy {

    @Override
    public Spot getParkingSpot(VehicleType type, List<Spot> spots) {
        for(Spot spot: spots) {
            if(spot.getType() == type && spot.isVacant) {
                return spot;
            }
        }
        throw new RuntimeException("No vacant spot available for " + type);
    }
}
