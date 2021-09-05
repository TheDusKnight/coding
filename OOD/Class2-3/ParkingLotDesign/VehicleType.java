package Class3.ParkingLotDesign;

public enum VehicleType {
    Motor(1),
    Compact(2),
    Bus(3);

    private final int size;

    VehicleType(final int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
