package leetcode._1603_DesignParkingSystem;

// Design
class ParkingSystem {
    int[] lots;
    
    public ParkingSystem(int big, int medium, int small) {
        lots = new int[] {big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (--lots[carType-1] < 0) return false;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
