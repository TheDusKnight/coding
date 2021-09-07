public class Level {
   private final int id;
   private final ParkingSpot[] spots;
   
   public Level(int id, int MotorCap, int CarCap, int BusCap) {
       this.id = id;
       for (int i = 0; i < MotorCap+CarCap+BustCap; i++) {
           if (i < MotorCap) {
               spots[i] = new ParkingSpot(Type.Motor);
           } else if (i >= MotorCap && i < MotorCap + CarCap) {
               spots[i] = new ParkingSpot(Type.Car);
           } else {
               spots[i] = new ParkingSpot(Type.Bus);
           }
       } 
   }

   public boolean canPark(Vehicle vehicle) {
       if (vehicle == null) return false;

       for (ParkingSpot spot : spots) {
           if (spot.canPark(vehicle)) return true;
       }
       return false;
   }

   public boolean goPark (Vehicle vehicle) {
       if (vehicle == null) return false;
       if (!canPark(vehicle)) return false;

       for (ParkingSpot spot : spots) {
           if (spot.goPark(vehicle)) return true;
       }
       return false;
   }

   public int numberOfAvailableSpot() {
       return -1;
   }
}
