public abstract class Vehicle {
   protected final long id;
   protected final VehicleType type;
   
   public Vehicle(long id, VehicleType type) {
       this.id = id;
       this.type = type;
   }

   public long getId() {
       return id;
   }

   public VehicleType getType() {
       return type;
   }
}
