public class ParkingLot {
    private final Level[] levels;

    public ParkingLot(int[][] design) {
        // cc

        int num = design.length;
        levels = new Level[num];
        for (int i = 0; i < num; i++) {
            levels[i] = new Level(i, design[i][0], design[i][1], design[i][2]);
        }

    }

    public boolean canPark(Vehicle vehicle) {
        // cc

        for (Level level: levels) {
            if (level.canPark(vehicle)) return true;
        }
        return false;
    }

    public boolean goPark(Vehicle vehicle) {
        // cc

        for (Level level: levels) {
            if (level.canPark(vehicle)) return level.goPark(vehicle);
        }
        return false;
    }
}
