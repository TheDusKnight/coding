public enum Status {
   UP("UP", 1), DOWN("DOWN", -1), PAUSE("PAUSE", 0);

   private String statusName;
   private int statueVal;

   Status(String statusName, int statueVal) {
      this.statusName = statusName;
      this.statueVal = statueVal;
   }

   public String toString() {
      return statusName;
   }

   public int getStatusVal() {
      return statueVal;
   }
}
