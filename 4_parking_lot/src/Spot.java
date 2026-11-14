import lombok.Getter;

@Getter
public class Spot {
    Long spotID;
    VehicleType type;
    boolean isVacant;

    Spot(VehicleType type, Long spotID) {
        this.type = type;
        this.isVacant = true;
        this.spotID = spotID;
    }

    public void occupySpot() {
        if(!isVacant) {
            throw new RuntimeException("Spot is already occupied");
        }
        isVacant = false;
    }

    public void vacateSpot() {
        if(isVacant) {
            throw new RuntimeException("Spot is already vacate");
        }
        isVacant = true;
    }
}
