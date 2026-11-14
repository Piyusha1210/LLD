# Entities
- ParkingLotSystem
- Spot
- Ticket
- Vehicle
- SpotType (enum)
- ParkingStrategy(interface)

- ParkingLotSystem
  - Map<Ticket, Spot> validTickets
  - List<Spot> spots
  - ParkingStrategy strategy

  + parkVehicle(Vehicle)
  + UnParkVehicle(Ticket)

- Spot
  - SpotType
  - isAvailable

  + isSpotAvailable()
  + occupySpot()
  + vacateSpot()