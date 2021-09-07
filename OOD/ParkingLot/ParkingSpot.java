public class ParkingSpot {
    private final Type type;
    private Vehicle curVehicle;

    public ParkingSpot(Type type) {
        this.type = type;
    }

    public Vehicle getCurVehicle() {
        return curVehicle;
    }

    public void setCurVehicle(Vehicle vehicle) {
        curVehicle = vehicle;
    }

    public Type getType() {
        return type;
    }

    public boolean canPark(Vehicle vehicle) {
        if (curVehicle != null) return false;
        if (getType().getTypeVal() >= vehicle.getType().getTypeVal()) return true;
        return false;
    }

    public synchronized boolean goPark(Vehicle vehicle) {
        if (!canPark(vehicle)) return false;

        curVehicle = vehicle;
        return true;
    }

    public Vehicle leavePark() {
        if (curVehicle == null) return null;

        // Vehicle leaveVehicle = new Vehicle(curVehicle.getId(), curVehicle.getType());
        Vehicle leaveVehicle = curVehicle;
        curVehicle = null;
        return leaveVehicle;
    }
}
