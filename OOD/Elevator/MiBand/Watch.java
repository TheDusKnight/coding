public abstract class Watch {
   protected int battery;
   
   public Watch(int battery) {
       this.battery = battery;
   }

   public setBattery(int battery) {
       // cc
       this.battery = battery;
   }

   public getBattery() {
       return battery;
   }

   public abstract void displayBattery();
}
