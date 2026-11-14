//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingLotSystem parkingLot = new ParkingLotSystem(new NearestSpotStrategy());

        // Park vehicle
        Ticket ticket = parkingLot.parkVehicle(new Vehicle("TR1", VehicleType.TRUCK));

        // Park same vehicle again
        parkingLot.parkVehicle(new Vehicle("TR1", VehicleType.TRUCK));
        parkingLot.unParkVehicle(ticket); // unpark vehicle

        Ticket t2Ticket = parkingLot.parkVehicle(new Vehicle("TR2", VehicleType.TRUCK));
        parkingLot.unParkVehicle(t2Ticket); // unpark vehicle
        parkingLot.unParkVehicle(t2Ticket); // unpark same vehicle again

        parkingLot.parkVehicle(new Vehicle("TR2", VehicleType.TRUCK));

        Ticket t3Ticket = parkingLot.parkVehicle(new Vehicle("TR3", VehicleType.TRUCK));

        Ticket ticket2 = parkingLot.parkVehicle(new Vehicle("CA1", VehicleType.CAR));
        parkingLot.parkVehicle(new Vehicle("CA2", VehicleType.CAR));

        Ticket bi1ticket3 = parkingLot.parkVehicle(new Vehicle("BI1", VehicleType.BIKE));
        bi1ticket3.ticketID = "123"; // invlaid ticketID
        parkingLot.unParkVehicle(bi1ticket3);

        parkingLot.unParkVehicle(null);


    }
}