import lombok.Getter;

@Getter
public class Vehicle {
    String regNumber;
    VehicleType vehicleType;

    Vehicle(String regNumber, VehicleType type) {
        this.vehicleType = type;
        this.regNumber = regNumber;
    }
}
