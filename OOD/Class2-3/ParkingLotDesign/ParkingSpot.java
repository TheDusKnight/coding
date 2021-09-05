package Class3.ParkingLotDesign;


public class ParkingSpot {
    private final String id;
    private Vehicle parkedVehicle;
    private final VehicleType spotType;

    public ParkingSpot(final String id, final VehicleType vehicleType) {
        this.id = id;
        this.spotType = vehicleType;
    }

    public boolean canPark(final Vehicle vehicle) {

        if(parkedVehicle != null) return false;

        return spotType.getSize() >= vehicle.getType().getSize();
    }

    public boolean isEmpty() {
        return parkedVehicle == null;
    }

    public boolean vehiclePark(final Vehicle vehicle) {
        if(!canPark(vehicle)) return false;

        parkedVehicle = vehicle;
        vehicle.setSpot(this);

        return true;
    }
}
