public class ParkingSpot {
    private final long id;
    private final Spot spot;

    public boolean canPark(Vehicle vehicle) {
        if (spot.value >= vehicle.type.value) {
            return true;
        } else return false;
    }
}
