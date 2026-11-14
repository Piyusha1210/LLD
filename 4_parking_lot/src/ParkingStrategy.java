import java.util.List;

public interface ParkingStrategy {

    Spot getParkingSpot(VehicleType type, List<Spot> spots);
}
