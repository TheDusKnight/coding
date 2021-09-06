public enum VehicleType {
    MOTOR("MOTOR", 1),
    SUV("SUV", 2),
    BUS("SUB", 3);

    private final String name;
    protected final int value;


    VehicleType(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
